package vuhidtools;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.lang.Exception;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * This class is the basic communication class to the VuHID server
 * @author Robert Hickey
 * @version 1.1
 *
 *  Ver 1.1     First version that implements stub methods for team.
 *      1.2     Added state final vars for Configuration and AuthenticationManager
 *              Added code to getStatusOfID from Peter to make it real
 *
 */
public class VUHIDSender implements VUHIDSenderInterface{

    private static final Configuration config = new Configuration();
    private static final AuthenticationManager am = new AuthenticationManager(config);

    private String vuhidServerURL = "\\testString\\forURL\\Server";

    public boolean setVuhidServer(String VuhidServerURL) {return true;}
    public String getVuhidServerURL() {return vuhidServerURL;}


/*	public String   getNewOVID() throws Exception{
		return "0000003693664829.210573940000000";
	}*/

    public String getNewOVID() throws Exception {
        String prefix = "0000003693664829"; //16 digits for prefix
        String checkDigits = "21057394";    //8 check digits
        String privacyClass = "0000000";    //OVID has 7 all zero privacy class digits
        String test = prefix + "." + checkDigits + privacyClass;
        return test;
    }

    public String getNewPVID() throws Exception {
        String prefix = "0123456789012345"; //16 digits for prefix
        String checkDigits = "01234567";    //8 check digits
        String privacyClass = "0123456";    //PVID has 7 (at least some) non-zero privacy class digits
        //String test = "0123456789012345.012345670000000" ;
        String test = prefix + "." + checkDigits + privacyClass;
        return test;
    }

/*    public int getStatusOfID(String ID) throws Exception {
        int test = 0;
        return test;
    }*/

    public int getStatusOfID(String ID) throws Exception {
        int test = 0;

        HttpsURLConnection connection = null;  //define here so I can return part of it outside try
        try {
            // create key and trust managers, then initialize the ssl context with their data
            SSLSocketFactory factory = am.getSSLSocketFactory();
            // communicate with the server
            //change this to incorporate passed PVID
            //URL url = new URL("https://" + config.getVuhidServerHostName() + "/verify/0000000406190821.350181120000000");
            URL url = new URL("https://" + config.getVuhidServerHostName() + "/verify/" + ID);

            //define connection outside of try block so can return some of it as string
            //HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection = (HttpsURLConnection) url.openConnection();

            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("From", config.getFromHeaderValue());
            connection.setRequestProperty("User-Agent", config.getUserAgentHeaderValue());
            connection.setRequestProperty("Host", config.getVuhidServerHostName());
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Content-Length", "32");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            connection.setSSLSocketFactory(factory);

            System.out.println("RESPONSE CODE: " + connection.getResponseCode());
            System.out.println("RESPONSE MESSAGE: " + connection.getResponseMessage());
            System.out.println("RESPONSE HEADERS:");
            for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
                System.out.println("\t" + header.getKey() + ": " + header.getValue());
            }
            System.out.println("DONE");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //return test;
        return connection.getResponseCode();
    }

    public int retireID(String ID, String reason) throws Exception {
        int test = 0;
        return test;
    }

    public int terminateID(String ID, String reason) throws Exception {
        int test = 0;
        return test;
    }

    public String getReplacementID() throws Exception {
        String prefix = "0123456789012345"; //16 digits for prefix
        String checkDigits = "01234567";    //8 check digits
        String privacyClass = "0000000";    //OVID has 7 all zero privacy class digits
        //String test = "0123456789012345.012345670000000" ;
        String test = prefix + "." + checkDigits + privacyClass;
        return test;
    }

    /*
    //routine returns replacement VuHID ID for given bad VuHID ID
    public String getReplacementID(String idToReplace, String reason) {
        String prefix = "0123456789012345"; //16 digits for prefix
        String checkDigits = "01234567";    //8 check digits
        String privacyClass = "0000000";    //OVID has 7 all zero privacy class digits
        //String test = "0123456789012345.012345670000000" ;
        String test = prefix + "." + checkDigits + privacyClass;
        return test;
    }
    */

    public String[] getDataLocations(String ID, String response_uri) throws Exception {
        String[] listOfReturnURLs = {"1", "2", "3", "4"};
        return listOfReturnURLs;
    }

/*
    public String[] getDataLocationsOfID(String idToSearchFor) {
        String[] listOfReturnURLs = {"1", "2", "3", "4"};
        return listOfReturnURLs;
    }
    */

    public boolean getIsOVID(String ID) throws Exception {
        return true;
    }

    public boolean getIsPVID(String ID) throws Exception {
        return true;
    }

    public boolean getIsWellFormed(String ID) throws Exception {
        return true;
    }

    public String getPrivacyClass(String ID) throws Exception {
        String prefix = "0123456789012345"; //16 digits for prefix
        String checkDigits = "01234567";    //8 check digits
        String privacyClass = "0000000";    //OVID has 7 all zero privacy class digits
        //String test = "0123456789012345.012345670000000" ;
        String test = prefix + "." + checkDigits + privacyClass;
        return privacyClass;
    }
}