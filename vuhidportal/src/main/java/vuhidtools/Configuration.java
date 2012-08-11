/* Configuration.java: Class for configuring mutually-authenticated HTTPS communication with VUHID */

package vuhidtools;

public class Configuration
{
    // Hostname for the VUHID test server
    private static String vuhidServerHostName = "testid.vuhid.org";
    // Keystore parameters
    private static String keyStoreFileName = "Certificates/PSU-VUHID-Portal.keystore";
    private static String keyStorePassword = "phlegmaticone";
    public static String keystoreFormat = "JKS";  // TODO: make private, and implement getters and setters
    // Certification Path Validation Algorithm (CPV Algorithm) for the keystore
    // (I think... see here: http://en.wikipedia.org/wiki/Certification_path_validation_algorithm
    public static String keystoreCPVAlgorithm = "SunX509";  // TODO: make private, and implement getters and setters
    // Truststore parameters
    private static String trustStoreFileName = "Certificates/GPII-CA.keystore";
    private static String trustStorePassword = "phlegmaticone";
    public static String truststoreFormat = "JKS";  // TODO: make private, and implement getters and setters
    // Certification Path Validation Algorithm (CPVA) for the truststore
    // (I think... see here: http://en.wikipedia.org/wiki/Certification_path_validation_algorithm)
    public static String truststoreCPVAlgorithm = "SunX509";  // TODO: make private, and implement getters and setters
    // Certificate alias TODO: learn more about this and how it should be used appropriately
    private static String alias = "1";
    // Security protocol that will be used for encrypting communication (e.g., "SSLv3" or "TLSv1")
    public static String securityProtocol = "TLS"; // TODO: make private, and implement getters and setters
    // HTTP headers
    private static String fromHeaderValue = "\"Peter Inslee of CsTheDay\" <pjinslee@cs.pdx.edu>";
    private static String userAgentHeaderValue = "VUHIDPortalPrototype";
    // TODO: Add and configure other headers here?...

    public boolean setVuhidServerHostName(String VuhidServerHostName) {
        // TODO: check for well formedness, maybe other validation?
        vuhidServerHostName = VuhidServerHostName;
        return true;
    }

    public String getVuhidServerHostName() {
        return vuhidServerHostName;
    }

    public boolean setKeyStoreFileName(String KeyStoreFileName) {
        // TODO:  check for well formedness, maybe other validation?
        keyStoreFileName = KeyStoreFileName;
        return true;
    }

    public String getKeyStoreFileName() {
        return keyStoreFileName;
    }

    public boolean setKeyStorePassword(String KeyStorePassword) {
        // TODO:  check for well formedness, maybe other validation?
        keyStorePassword = KeyStorePassword;
        return true;
    }

    public String getKeyStorePassword() {
        return keyStorePassword;
    }

    public boolean setTrustStoreFileName(String TrustStoreFileName) {
        // TODO:  check for well formedness, maybe other validation?
        trustStoreFileName = TrustStoreFileName;
        return true;
    }

    public String getTrustStoreFileName() {
        return trustStoreFileName;
    }

    public boolean setTrustStorePassword(String TrustStorePassword) {
        // TODO:  check for well formedness, maybe other validation?
        trustStorePassword = TrustStorePassword;
        return true;
    }

    public String getTrustStorePassword() {
        return trustStorePassword;
    }

    public boolean setAlias(String Alias) {
        // TODO:  check for well formedness, maybe other validation?
        alias = Alias;
        return true;
    }

    public String getAlias() {
        return alias;
    }

    public boolean setFromHeaderValue(String FromHeaderValue) {
        // TODO:  check for well formedness, maybe other validation?
        fromHeaderValue = FromHeaderValue;
        return true;
    }

    public String getFromHeaderValue() {
        return fromHeaderValue;
    }

    public boolean setUserAgentHeaderValue(String UserAgentHeaderValue) {
        // TODO:  check for well formedness, maybe other validation?
        userAgentHeaderValue = UserAgentHeaderValue;
        return true;
    }

    public String getUserAgentHeaderValue() {
        return userAgentHeaderValue;
    }
}

