package vuhidtools;
/*
 * VUHIDSender.java: Basic outline of interface for sending requests to VUHID.
*/
public interface VUHIDSenderInterface {

    public String   getNewOVID() throws Exception;
    public String   getNewPVID() throws Exception;
    public int      getStatusOfID(String ID) throws Exception;
    public int      retireID(String ID, String reason) throws Exception;
    public int      terminateID(String ID, String reason) throws Exception;
    public String   getReplacementID() throws Exception;
    public String[] getDataLocations(String ID, String response_uri) throws Exception;

    public boolean  getIsOVID(String ID) throws Exception;
    public boolean  getIsPVID(String ID) throws Exception;
    public boolean  getIsWellFormed(String ID) throws Exception;
    public String   getPrivacyClass(String ID) throws Exception;
};
