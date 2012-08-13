/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package vuhidtools.logger;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import vuhidtools.Config;
import vuhidtools.TransactionLoggerInterface;

/**
 * This class is the Transaction Logger.<br>
 * It connect to the database.<br>
 * Transaction status: 0 - not started, 1 - started, 2 - completed.<br>
 */
public class TransactionLogger implements TransactionLoggerInterface
{
	public int newTransaction(int type, String previous_transaction, String[] values)
	{
		DatabaseHandler.connect();
		String Hash = "";
		String CurrentTimeStamp = SHA1Calculator.getCurrentTimeStamp();
		try // Calculate an unique transaction ID using SHA1
		{
			Hash = SHA1Calculator.SHA1(Integer.toString(type) + previous_transaction + values.toString() + CurrentTimeStamp);
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		switch(type)
		{
			case 1: // New OVID
			{
				DatabaseHandler.query("INSERT INTO `Transactions` (`Hash`, `Type`, `Time`) VALUES (\'" + Hash + "\', '1', \'" + CurrentTimeStamp + "\')");
				break;
			}
			case 2: // New PVID: values[0] is the PC
			case 3: // VUHID ID Status: values[0] is the VUHID ID
			{
				DatabaseHandler.query("INSERT INTO `Transactions` (`Hash`, `Type`, `Time`, `InputValue1`) VALUES (\'" + Hash + "\', \'" + type + "\', \'" + CurrentTimeStamp + "\', \'" + values[0] + "\')");
				break;
			}
			case 4: // Retire ID: values[0] is the VUHID ID, values[1] is the reason
			case 5: // Terminate ID: values[0] is the VUHID ID, values[1] is the reason
			case 6: // Request data locations: values[0] is the VUHID ID, values[1] is the reason
			case 7: // Replace ID: values[0] is the VUHID ID, values[1] is the reason
			{
				DatabaseHandler.query("INSERT INTO `Transactions` (`Hash`, `Type`, `Time`, `InputValue1`, `InputValue2`) VALUES (\'" + Hash + "\', \'" + type + "\', \'" + CurrentTimeStamp + "\', \'" + values[0] + "\', \'" + values[1] + "\')");
				break;
			}
			case 8: // VUHID Retirement/Termination Notice
			{
				// TODO
				break;
			}
			case 9: // VUHID Replacement Notice
			{
				// TODO
				break;
			}
		}
		return getTransactionID(Hash);
	}
	private static int getTransactionID(String Hash)
	{
		DatabaseHandler.query("SELECT `ID` FROM `Transactions` WHERE `Hash` = \'" + Hash + "\'");
		try
		{
			return DatabaseHandler.getResult().getInt(1);
		}
		catch (SQLException e)
		{
			System.err.println("Got an exception!");
	    	System.err.println(e.getMessage());
	    	return -1;
		}
	}
	public void setTransactionCompleted(int ID)
	{
		DatabaseHandler.query("UPDATE `Transactions` SET `Completed` = True WHERE `ID` = \'" + ID + "\'");
	}
	/*public static void main(String[] args)
	{
		TransactionLogger logger = new TransactionLogger();
		Config.loadConfiguration();
		String[] test = new String[3];
		test[0] = "input msg1";
		test[1] = "input msg2";
		test[2] = "output msg";
		int ID = logger.newTransaction(7, "", test);
		logger.setTransactionCompleted(ID);
	}*/
}