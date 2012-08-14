package vuhidtools;

import java.lang.Exception;

/**
 * This class is the basic communication class to the VuHID server
 * @author Robert Hickey
 * @version 1.1
 *
 *  Ver 1.1     First version that implements stub methods for team.
 *
 */
public class VUHIDSender implements VUHIDSenderInterface{

    private String vuhidServerURL = "\\testString\\forURL\\Server";

    public boolean setVuhidServer(String VuhidServerURL) {return true;}
    public String getVuhidServerURL() {return vuhidServerURL;}


/*	public String   getNewOVID() throws Exception{
		return "0000003693664829.210573940000000";
	}*/


    public String getNewOVID() {
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

    public int getStatusOfID(String ID) throws Exception {
        int test = 0;
        return test;
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