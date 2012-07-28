/*
 * VUHIDSender.java: Basic outline of interface for sending requests to VUHID.
*/
public VUHIDSender interface {

    public String   getNewOVID() throws ServerErrorException;
    public String   getNewPVID() throws ServerErrorException;
    public int      getStatusOfID(String ID) throws ServerErrorException;
    public int      retireID(String ID, String reason) throws ServerErrorException;
    public int      terminateID(String ID, String reason) throws ServerErrorException;
    public String   getReplacementID() throws ServerErrorException;
    public String[] getDataLocations(String ID, String response_uri) throws ServerErrorException;

    public boolean  getIsOVID(String ID) throws ServerErrorException;
    public boolean  getIsPVID(String ID) throws ServerErrorException;
    public boolean  getIsWellFormed(String ID) throws ServerErrorException;
    public String   getPrivacyClass(String ID) throws ServerErrorException;
}
