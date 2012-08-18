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
 * This class is the Transaction Logger.
 * It connect to the database.
 * And log 14 transactions.
 */
public class TransactionLogger implements TransactionLoggerInterface
{
	private static DatabaseHandler database = new DatabaseHandler();
	public int newTransaction(int type, String previous_transaction, String[] values)
	{
		database.connect();
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
			case 10: // PIX PatientRegistryRecordRevised
			case 11: // PIX PatientRegistryRecordAdded
			case 12: // PIX PatientRegistryGetIdentifiersQuery
			case 13: // PIX PatientRegistryDuplicatesResolved
			case 14: // PDQ PatientRegistryFindCandidatesQuery
			{
				database.query("INSERT INTO `Transactions` (`Hash`, `Type`, `Time`) VALUES (\'" + Hash + "\', '1', \'" + CurrentTimeStamp + "\')");
				break;
			}
			case 2: // New PVID: values[0] is the PC
			case 3: // VUHID ID Status: values[0] is the VUHID ID
			case 6: // Request data locations: values[0] is the VUHID ID
			{
				database.query("INSERT INTO `Transactions` (`Hash`, `Type`, `Time`, `InputValue1`) VALUES (\'" + Hash + "\', \'" + type + "\', \'" + CurrentTimeStamp + "\', \'" + values[0] + "\')");
				break;
			}
			case 4: // Retire ID: values[0] is the VUHID ID, values[1] is the reason
			case 5: // Terminate ID: values[0] is the VUHID ID, values[1] is the reason
			case 7: // Replace ID: values[0] is the VUHID ID, values[1] is the reason
			{
				database.query("INSERT INTO `Transactions` (`Hash`, `Type`, `Time`, `InputValue1`, `InputValue2`) VALUES (\'" + Hash + "\', \'" + type + "\', \'" + CurrentTimeStamp + "\', \'" + values[0] + "\', \'" + values[1] + "\')");
				break;
			}
			case 8: // VUHID Retirement/Termination Notice: values[0] is the VUHID ID, values[1] is the action taken, values[2] is the URL of the EMPI that has requested the change, values[3] is the time stamp, values[4] is the reason
			case 9: // VUHID Replacement Notice: values[0] is the old VUHID ID, values[1] is the new VUHID ID, values[2] is the URL of the EMPI that has requested the change, values[3] is the time stamp, values[4] is the reason
			{
				database.query("INSERT INTO `Transactions` (`Hash`, `Type`, `Time`, `InputValue1`, `InputValue2`, `InputValue3`, `InputValue4`) VALUES (\'" + Hash + "\', \'" + type + "\', \'" + CurrentTimeStamp + "\', \'" + values[0] + "\', \'" + values[1] + "\')" + "\', \'" + values[2] + "\')" + "\', \'" + values[3] + "\')" + "\', \'" + values[4] + "\')");
				break;
			}
		}
		return getTransactionID(Hash);
	}
	public int newTransaction(int type, String[] values)
	{
		return newTransaction(type, "-1", values);
	}
	public int newTransaction(int type, String previous_transaction)
	{
		String[] values = new String[1];
		values[0] = "";
		return newTransaction(type, previous_transaction, values);
	}
	public int newTransaction(int type)
	{
		return newTransaction(type, "-1");
	}
	private static int getTransactionID(String Hash)
	{
		database.query("SELECT `ID` FROM `Transactions` WHERE `Hash` = \'" + Hash + "\'");
		try
		{
			return database.getResult().getInt(1);
		}
		catch (SQLException e)
		{
			System.err.println("Got an exception!");
	    	System.err.println(e.getMessage());
	    	return -1;
		}
	}
	private static int getTransactionType(int ID)
	{
		database.query("SELECT `Type` FROM `Transactions` WHERE `ID` = \'" + ID + "\'");
		try
		{
			return database.getResult().getInt(1);
		}
		catch (SQLException e)
		{
			System.err.println("Got an exception!");
	    	System.err.println(e.getMessage());
	    	return -1;
		}
	}
	public void setTransactionCompleted(int ID, String return_value)
	{
		database.query("UPDATE `Transactions` SET `ReturnValue` = \'" + return_value + "\' WHERE `ID` = \'" + ID + "\'");
		database.query("UPDATE `Transactions` SET `Completed` = True WHERE `ID` = \'" + ID + "\'");
	}
	public void setTransactionCompleted(int ID)
	{
		setTransactionCompleted(ID, "");
	}
	public void logSearch(boolean VUHID_ID, boolean Success)
	{
		String CurrentTimeStamp = SHA1Calculator.getCurrentTimeStamp();
		database.query("INSERT INTO `Searches` (`Time`, `VUHID_ID`, `Success`) VALUES (\'" + CurrentTimeStamp + "\', \'" + VUHID_ID + "\', \'" + Success + "\')");
	}
	public void report(String FileLocation, int Month, int Year)
	{
		Report.generateReport(FileLocation, Month, Year);
	}
	/*public static void main(String[] args)
	{
		TransactionLogger logger = new TransactionLogger();
		Config.loadConfiguration();
		String[] test = new String[3];
		test[0] = "input msg1";
		test[1] = "input msg2";
		test[2] = "output msg";
		int ID = logger.newTransaction(1);
		logger.setTransactionCompleted(ID, "Test return");
		logger.report("C:\\Test.xls", 8, 2012);
	}*/
}