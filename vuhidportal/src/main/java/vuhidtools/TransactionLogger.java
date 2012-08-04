package vuhidtools;

import java.sql.SQLException;
import vuhidtools.Config;
import vuhidtools.DatabaseHandler;

/**
 * This class is the Transaction Logger.<br>
 * It connect to the database.<br>
 */
public class TransactionLogger implements TransactionLoggerInterface
{
	public int log(int type, int previous_transaction, String[] values)
	{
		DatabaseHandler.connect();
		switch(type)
		{
			case 1: // New OVID: values[0] is the returned OVID
			{
				DatabaseHandler.query("INSERT INTO Transactions(Type, ReturnValue) VALUES (1, " + values[0] + ")");
				break;
			}
			case 2: // New PVID: values[0] is the PC, values[1] is the returned PVID
			{
				DatabaseHandler.query("INSERT INTO Transactions(Type, InputValue1, ReturnValue) VALUES (2, " + values[0] + ", " + values[1] + ")");
				break;
			}
			case 3: // VUHID ID Status: values[0] is the VUHID ID, values[1] is the returned status code
			{
				DatabaseHandler.query("INSERT INTO Transactions(Type, InputValue1, ReturnValue) VALUES (3, " + values[0] + ", " + values[1] + ")");
				break;
			}
			case 4: // Retire ID: values[0] is the VUHID ID, values[1] is the reason, values[2] is the returned status code
			{
				DatabaseHandler.query("INSERT INTO Transactions(Type, InputValue1, InputValue2, ReturnValue) VALUES (4, " + values[0] + ", " + values[1] + ", " + values[2] + ")");
				break;
			}
			case 5: // Terminate ID: values[0] is the VUHID ID, values[1] is the reason, values[2] is the returned status code
			{
				DatabaseHandler.query("INSERT INTO Transactions(Type, InputValue1, InputValue2, ReturnValue) VALUES (5, " + values[0] + ", " + values[1] + ", " + values[2] + ")");
				break;
			}
			case 6: // Request data locations: values[0] is the VUHID ID, values[1] is the reason, values[2] is the returned status code
			{
				// TODO
				break;
			}
			case 7: // Replace ID: values[0] is the VUHID ID, values[1] is the reason, values[2] is the returned ?? TODO
			{
				// TODO
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
		return getLastID();
	}
	public int log(int type, String[] values)
	{
		return log(type, -1, values);
	}
	private static int getLastID()
	{
		DatabaseHandler.query("SELECT ID FROM Transactions ORDER BY ID DESC LIMIT 1");
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
		DatabaseHandler.query("UPDATE Transactions SET Completed = true WHERE ID = " + ID);
	}
	public static void main(String[] args)
	{
		Logger logger = new Logger();
		Config.loadConfiguration();
		String[] test = new String[2];
		test[0] = "input msg";
		test[1] = "output msg";
		int ID = logger.log(1, 1, test);
	}
}