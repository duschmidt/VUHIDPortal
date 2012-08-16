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

/**
 * Authors: Long Phan, Robert Hickey, Peter Inslee
 * Date: 2012-08-15
 * @version 1.2
 * Comments:    Ver 1.0 2012-07-25 Long created "Config.java" for loading the database configuration
 *                                 settings from a file, using "PropertyLoader.java".
 *              Ver 1.0 2012-08-11 Peter created "Configuration.java" for storing hard-coded VUHID server
 *                                 configuration settings with some getter and setter methods.
 *              Ver 1.1 2012-08-12 Robert changed public class vars to private, and generated getter/setter
 *                                 methods for them in "Configuration.java".
 *              Ver 1.2 2012-08-15 Peter merged code from "Configuration.java" into "Config.java" so all
 *                                 settings are managed and loaded from files by a single class.
 */
package vuhidtools;

import java.util.Properties;
import vuhidtools.PropertyLoader;

/**
 * This class contains the global VUHID Portal configuration.<br>
 * It has static final fields initialized from configuration files.<br>
 * It's initialized at the very beginning of startup, and later the JIT compilation will optimize away
 * debug and unused code.
 */
public class Config extends PropertyLoader
{
    public static final String  DB_CONFIGURATION_FILE = "config/server.properties";
    public static final String  VUHID_CONFIGURATION_FILE = "config/vuhid.properties";
    public static final String  EMPI_CONFIGURATION_FILE = "config/empi.properties";

    // Database server configuration
    public static String        DATABASE_DRIVER;
    public static String        DATABASE_URL;
    public static String        DATABASE_LOGIN;
    public static String        DATABASE_PASSWORD;
    public static int           DATABASE_MAX_CONNECTIONS;

    // VUHID server configuration
    private static String       vuhidServerHostName;
    private static String       alias;
    private static String       keystoreCPVAlgorithm;
    private static String       keyStoreFileName;
    private static String       keystoreFormat;
    private static String       keyStorePassword;
    private static String       trustStoreCPVAlgorithm;
    private static String       trustStoreFileName;
    private static String       trustStoreFormat;
    private static String       trustStorePassword;
    private static String       securityProtocol;
    private static String       fromHeaderValue;
    private static String       userAgentHeaderValue;

    // TODO: EMPI server configuration (This is just tentative placeholder stuff.)
    // private static String       empiPDSService;
    // private static String       empiPIXManagerService;

    public static void loadConfiguration()
    {
        Properties settings;

        // Load database server configuration
        try {
            settings = PropertyLoader.loadProperties(DB_CONFIGURATION_FILE);

            DATABASE_DRIVER = settings.getProperty("Driver", "com.mysql.jdbc.Driver");
            DATABASE_URL = settings.getProperty("URL", "jdbc:mysql://localhost/vuhid-portal");
            DATABASE_LOGIN = settings.getProperty("Login", "root");
            DATABASE_PASSWORD = settings.getProperty("Password", "");
            DATABASE_MAX_CONNECTIONS = Integer.parseInt(settings.getProperty("MaximumDbConnections", "10"));
        } catch (Exception e) {
            throw new Error("Failed to Load " + DB_CONFIGURATION_FILE + " File.");
        }

        // Load VUHID server configuration
        try {
            settings = PropertyLoader.loadProperties(VUHID_CONFIGURATION_FILE);

            vuhidServerHostName = settings.getProperty("vuhidServerHostName", "testid.vuhid.org");
            keyStoreFileName = settings.getProperty("keyStoreFileName", "Certificates/PSU-VUHID-Portal.keystore");
            keyStorePassword = settings.getProperty("keyStorePassword", "phlegmaticone");
            keystoreFormat = settings.getProperty("keystoreFormat", "JKS");
            keystoreCPVAlgorithm = settings.getProperty("keystoreCPVAlgorithm", "SunX509");
            trustStoreFileName = settings.getProperty("trustStoreFileName", "Certificates/GPII-CA.keystore");
            trustStorePassword = settings.getProperty("trustStorePassword", "phlegmaticone");
            trustStoreFormat = settings.getProperty("trustStoreFormat", "JKS");
            trustStoreCPVAlgorithm = settings.getProperty("trustStoreCPVAlgorithm", "SunX509");
            alias = settings.getProperty("alias", "1");
            securityProtocol = settings.getProperty("securityProtocol", "TLS");
            fromHeaderValue = settings.getProperty("fromHeaderValue", "\"Robert Hickey of CsTheDay\" <rhickey@cecs.pdx.edu>");
            userAgentHeaderValue = settings.getProperty("userAgentHeaderValue", "VUHIDPortalPrototype");
        } catch (Exception e) {
            throw new Error("Failed to Load " + VUHID_CONFIGURATION_FILE + " File.");
        }

        // TODO: Load EMPI server configuration  (This is just tentative placeholder stuff.)
        /*try {
            settings = PropertyLoader.loadProperties(EMPI_CONFIGURATION_FILE);

            empiPDSService = settings.getProperty("empiPDSService", "http://208.81.185.143:8080/axis2/services/pds");
            empiPIXManagerService = settings.getProperty("empiPIXManagerService", "http://208.81.185.143:8080/axis2/services/pixmgr");
        } catch (Exception e) {
            throw new Error("Failed to Load " + EMPI_CONFIGURATION_FILE + " File.");
        }*/
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

    // ***************  GETTERS  **************************************************************************

    public String getAlias() {
        return alias;
    }

    public String getVuhidServerHostName() {
        return vuhidServerHostName;
    }

    public String getKeystoreCPVAlgorithm() {
        return keystoreCPVAlgorithm;
    }

    public String getKeyStoreFileName() {
        return keyStoreFileName;
    }

    public String getKeystoreFormat() {
        return keystoreFormat;
    }

    public String getKeyStorePassword() {
        return keyStorePassword;
    }

    public String getTrustStoreCPVAlgorithm() {
        return trustStoreCPVAlgorithm;
    }

    public String getTrustStoreFileName() {
        return trustStoreFileName;
    }

    public String getTrustStoreFormat() {
        return trustStoreFormat;
    }

    public String getTrustStorePassword() {
        return trustStorePassword;
    }

    public String getSecurityProtocol() {
        return securityProtocol;
    }

    public String getFromHeaderValue() {
        return fromHeaderValue;
    }

    public String getUserAgentHeaderValue() {
        return userAgentHeaderValue;
    }

    // ***************  SETTERS  **************************************************************************

    public boolean setAlias(String alias) {
        // TODO:  check for well formedness, maybe other validation?
        // if (alias is valid) {
            this.alias = alias;
            return true;
        // } else {
        //     return false;
        // }
    }

    public boolean setVuhidServerHostName(String vuhidServerHostName) {
        this.vuhidServerHostName = vuhidServerHostName;
        return true;
    }

    public boolean setKeystoreCPVAlgorithm(String keystoreCPVAlgorithm) {
        this.keystoreCPVAlgorithm = keystoreCPVAlgorithm;
        return true;
    }

    public boolean setKeyStoreFileName(String keyStoreFileName) {
        this.keyStoreFileName = keyStoreFileName;
        return true;
    }

    public boolean setKeystoreFormat(String keystoreFormat) {
        this.keystoreFormat = keystoreFormat;
        return true;
    }

    public boolean setKeyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
        return true;
    }

    public boolean setTrustStoreCPVAlgorithm(String trustStoreCPVAlgorithm) {
        this.trustStoreCPVAlgorithm = trustStoreCPVAlgorithm;
        return true;
    }

    public boolean setTrustStoreFileName(String trustStoreFileName) {
        this.trustStoreFileName = trustStoreFileName;
        return true;
    }

    public boolean setTrustStoreFormat(String trustStoreFormat) {
        this.trustStoreFormat = trustStoreFormat;
        return true;
    }

    public boolean setTrustStorePassword(String trustStorePassword) {
        this.trustStorePassword = trustStorePassword;
        return true;
    }

    public boolean setSecurityProtocol(String securityProtocol) {
        this.securityProtocol = securityProtocol;
        return true;
    }

    public boolean setFromHeaderValue(String fromHeaderValue) {
        this.fromHeaderValue = fromHeaderValue;
        return true;
    }

    public boolean setUserAgentHeaderValue(String userAgentHeaderValue) {
        this.userAgentHeaderValue = userAgentHeaderValue;
        return true;
    }
}

