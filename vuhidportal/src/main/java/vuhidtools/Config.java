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
package vuhidtools;

import java.util.Properties;
import vuhidtools.PropertyLoader;


/**
 * This class contains global server configuration.<br>
 * It has static final fields initialized from configuration files.<br>
 * It's initialized at the very begin of startup, and later JIT will optimize
 * away debug/unused code.
 */
public class Config extends PropertyLoader
{
	// *******************************************************************************************
	public static final String	CONFIGURATION_FILE					= "config/server.properties";
	// *******************************************************************************************
	public static String		DATABASE_DRIVER;																	// Driver to access to database
	public static String		DATABASE_URL;																		// Path to access to database
	public static String		DATABASE_LOGIN;																		// Database login
	public static String		DATABASE_PASSWORD;																	// Database password
	public static int			DATABASE_MAX_CONNECTIONS;															// Maximum number of connections to the database

	// *******************************************************************************************
	public static void loadConfiguration()
	{
		try
		{
			
			Properties serverSettings = PropertyLoader.loadProperties(CONFIGURATION_FILE);

			DATABASE_DRIVER = serverSettings.getProperty("Driver", "com.mysql.jdbc.Driver");
			DATABASE_URL = serverSettings.getProperty("URL", "jdbc:mysql://localhost/l2jdb");
			DATABASE_LOGIN = serverSettings.getProperty("Login", "root");
			DATABASE_PASSWORD = serverSettings.getProperty("Password", "");
			DATABASE_MAX_CONNECTIONS = Integer.parseInt(serverSettings.getProperty("MaximumDbConnections", "10"));
		}
		catch (Exception e)
		{
			throw new Error("Failed to Load " + CONFIGURATION_FILE + " File.");
		}
	}
}
/*	
	public static void load() throws Exception
	{
		Util.printSection("Configuration");
		loadConfiguration();
		loadHexId();
		loadSubnets();
		loadTelnetConfig();
		loadIdFactoryConfig();
		loadDateTimeConfig();
		initDBProperties();

		L2Config.loadConfigs();

		registerConfig(new AllConfig());
	}

	private static final class AllConfig extends ConfigLoader
	{
		@Override
		protected String getName()
		{
			return "all";
		}
		
		private boolean _reloading = false;
		
		@Override
		protected void load() throws Exception
		{
			if (_reloading)
				return;
			
			_reloading = true;
			try
			{
				Config.load();
			}
			finally
			{
				_reloading = false;
			}
		}
	}

	// it has no instancies
	protected Config()
	{
	}
	
	public static void initDBProperties()
	{
		System.setProperty("teamc.db.driverclass", DATABASE_DRIVER);
		System.setProperty("teamc.db.urldb", DATABASE_URL);
		System.setProperty("teamc.db.user", DATABASE_LOGIN);
		System.setProperty("teamc.db.password", DATABASE_PASSWORD);
		System.setProperty("teamc.db.maximum.db.connection", Integer.toString(DATABASE_MAX_CONNECTIONS));
	}
}*/
