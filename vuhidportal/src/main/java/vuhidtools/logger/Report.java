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

/**
 * This class is the Transaction Logger.<br>
 * It connect to the database.<br>
 */
public class Report
{
	private static DatabaseHandler database = new DatabaseHandler();
	private static ExcelHandler excel = new ExcelHandler();
	public static void generateReport(String FileLocation, int Month, int Year)
	{
		try
	    {
			database.connect();
			String[] inputLabels = new String[6];
			inputLabels[0] = "Number of IDs issued";
			inputLabels[1] = "Number of searches performed";
			inputLabels[2] = "Number of successful searches performed";
			inputLabels[3] = "Number of failed searches performed";
			inputLabels[4] = "Number of successful searches with provided VUHID ID performed";
			inputLabels[5] = "Number of failed searches with provided VUHID ID performed";
			String[][] inputContents = new String[6][2];
			inputContents[0] = numberOfIDsIssued(Month, Year);
			inputContents[1] = numberOfSearches(Month, Year);
			inputContents[2] = numberOfSuccessfulSearches(Month, Year, true);
			inputContents[3] = numberOfSuccessfulSearches(Month, Year, false);
			inputContents[4] = numberOfSearchesWithID(Month, Year, true);
			inputContents[5] = numberOfSearchesWithID(Month, Year, false);
			excel.setOutputFile(FileLocation);
			excel.write(Month, Year, inputLabels, inputContents);
	    }
	    catch (Exception e)
	    {
	    	System.err.println("Got an exception!");
	    	System.err.println(e.getMessage());
	    }
	}
	private static String[] numberOfIDsIssued(int Month, int Year)
	{
		try
	    {
			String[] Result = new String[2];
			database.query("SELECT COUNT(ID) FROM `Transactions` " + monthlyRange(Month, Year) + " AND (`Type` = '1' OR `Type` = '2')");
			Result[0] = database.getResult().getString(1); // Monthly total
			database.query("SELECT COUNT(ID) FROM `Transactions` " + yearToDateRange(Month, Year) + " AND (`Type` = '1' OR `Type` = '2')");
			Result[1] = database.getResult().getString(1); // Year-to-date total
			return Result;
	    }
	    catch (Exception e)
	    {
	    	System.err.println("Got an exception!");
	    	System.err.println(e.getMessage());
			return null;
	    }
	}
	private static String[] numberOfSearches(int Month, int Year)
	{
		try
	    {
			String[] Result = new String[2];
			database.query("SELECT COUNT(ID) FROM `Searches` " + monthlyRange(Month, Year));
			Result[0] = database.getResult().getString(1); // Monthly total
			database.query("SELECT COUNT(ID) FROM `Searches` " + yearToDateRange(Month, Year));
			Result[1] = database.getResult().getString(1); // Year-to-date total
			return Result;
	    }
	    catch (Exception e)
	    {
	    	System.err.println("Got an exception!");
	    	System.err.println(e.getMessage());
			return null;
	    }
	}
	private static String[] numberOfSuccessfulSearches(int Month, int Year, boolean Success)
	{
		try
	    {
			String[] Result = new String[2];
			database.query("SELECT COUNT(ID) FROM `Searches` " + monthlyRange(Month, Year) + " AND `Success` = " + Success);
			Result[0] = database.getResult().getString(1); // Monthly total
			database.query("SELECT COUNT(ID) FROM `Searches` " + yearToDateRange(Month, Year) + " AND `Success` = " + Success);
			Result[1] = database.getResult().getString(1); // Year-to-date total
			return Result;
	    }
	    catch (Exception e)
	    {
	    	System.err.println("Got an exception!");
	    	System.err.println(e.getMessage());
			return null;
	    }
	}
	private static String[] numberOfSearchesWithID(int Month, int Year, boolean Success)
	{
		try
	    {
			String[] Result = new String[2];
			database.query("SELECT COUNT(ID) FROM `Searches` " + monthlyRange(Month, Year) + " AND `Success` = " + Success + " AND `VUHID_ID` = true");
			Result[0] = database.getResult().getString(1); // Monthly total
			database.query("SELECT COUNT(ID) FROM `Searches` " + yearToDateRange(Month, Year) + " AND `Success` = " + Success + " AND `VUHID_ID` = true");
			Result[1] = database.getResult().getString(1); // Year-to-date total
			return Result;
	    }
	    catch (Exception e)
	    {
	    	System.err.println("Got an exception!");
	    	System.err.println(e.getMessage());
			return null;
	    }
	}
	private static String monthlyRange(int Month, int Year)
	{
		try
	    {
			int NextMonth = 0;
			int NextYear = Year;
			if(Month <= 12)
			{
				NextMonth = Month + 1;
			}
			else
			{
				NextMonth = 1;
				NextYear = Year + 1;
			}
			return "WHERE `Time` >= \'" + Year + "-" + Month + "-01 00:00:00\' AND `Time` < \'" + NextYear + "-" + NextMonth + "-01 00:00:00\'";
	    }
	    catch (Exception e)
	    {
	    	System.err.println("Got an exception!");
	    	System.err.println(e.getMessage());
			return null;
	    }
	}
	private static String yearToDateRange(int Month, int Year)
	{
		try
	    {
			int NextMonth = 0;
			int NextYear = Year;
			if(Month <= 12)
			{
				NextMonth = Month + 1;
			}
			else
			{
				NextMonth = 1;
				NextYear = Year + 1;
			}
			return "WHERE `Time` >= \'" + Year + "-01-01 00:00:00\' AND `Time` < \'" + NextYear + "-" + NextMonth + "-01 00:00:00\'";
	    }
	    catch (Exception e)
	    {
	    	System.err.println("Got an exception!");
	    	System.err.println(e.getMessage());
			return null;
	    }
	}
}