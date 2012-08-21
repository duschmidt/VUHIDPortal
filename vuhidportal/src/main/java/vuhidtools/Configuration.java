package vuhidtools;

/**
 * Author: Robert Hickey
 * Date: 8/11/12
 * @version 1.1
 * Comments:    Ver 1.0 First version copied from Peter's work
 *              Ver 1.1 Changed Peter's public class vars to private and generated getter/setter methods for them
 */
public class Configuration {

    // Hostname for the VUHID test server
    private static String vuhidServerHostName = "testid.vuhid.org";

    // Keystore parameters
    private static String keyStoreFileName = "Certificates/PSU-VUHID-Portal.keystore";
    private static String keyStorePassword = "phlegmaticone";
    private static String keystoreFormat = "JKS";  // DONE: make private, and implement getters and setters

    // Certification Path Validation Algorithm (CPV Algorithm) for the keystore
    // (I think... see here: http://en.wikipedia.org/wiki/Certification_path_validation_algorithm
    private static String keystoreCPVAlgorithm = "SunX509";  // DONE: make private, and implement getters and setters

    // Truststore parameters
    private static String trustStoreFileName = "Certificates/GPII-CA.keystore";
    private static String trustStorePassword = "phlegmaticone";
    private static String trustStoreFormat = "JKS";  // DONE: make private, and implement getters and setters
    // Certification Path Validation Algorithm (CPVA) for the truststore
    // (I think... see here: http://en.wikipedia.org/wiki/Certification_path_validation_algorithm)
    private static String trustStoreCPVAlgorithm = "SunX509";  // DONE: make private, and implement getters and setters
    // Certificate alias TODO: learn more about this and how it should be used appropriately
    private static String alias = "1";
    // Security protocol that will be used for encrypting communication (e.g., "SSLv3" or "TLSv1")
    private static String securityProtocol = "TLS"; // DONE: make private, and implement getters and setters

    // HTTP headers
    private static String fromHeaderValue = "\"Peter Inslee of CsTheDay\" <pjinslee@cs.pdx.edu>";
    private static String userAgentHeaderValue = "VUHIDPortalPrototype";
    // TODO: Add and configure other headers here?...


    //***************  GETTER AND SETTERS  **************************

    public static String getKeystoreFormat() {
        return keystoreFormat;
    }

    public static void setKeystoreFormat(String keystoreFormat) {
        Configuration.keystoreFormat = keystoreFormat;
    }

    public static String getKeystoreCPVAlgorithm() {
        return keystoreCPVAlgorithm;
    }

    public static void setKeystoreCPVAlgorithm(String keystoreCPVAlgorithm) {
        Configuration.keystoreCPVAlgorithm = keystoreCPVAlgorithm;
    }

    public static String getTrustStoreFormat() {
        return trustStoreFormat;
    }

    public static void setTrustStoreFormat(String trustStoreFormat) {
        Configuration.trustStoreFormat = trustStoreFormat;
    }

    public static String getTrustStoreCPVAlgorithm() {
        return trustStoreCPVAlgorithm;
    }

    public static void setTrustStoreCPVAlgorithm(String trustStoreCPVAlgorithm) {
        Configuration.trustStoreCPVAlgorithm = trustStoreCPVAlgorithm;
    }

    public static String getSecurityProtocol() {
        return securityProtocol;
    }

    public static void setSecurityProtocol(String securityProtocol) {
        Configuration.securityProtocol = securityProtocol;
    }

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
