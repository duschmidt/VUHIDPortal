package vuhidtools;

/**
 * Author: Robert Hickey
 * Date: 8/11/12
 * @version 1.2
 * Comments:    Ver 1.0 First version of Peter's work
 *                  1.1 Moved code to validate ID into getStatusID routine of VUHIDSender.java
 *                      Tested with old code here commented out and works as before
 *                  1.2 Added routine to test getNewOVID routine
 *                      Added routine to test getNewPVID routine
 *                      Added routine to test retireID routine
 *
 */
public class VUHIDPortalPrototype {
    //PI: private static final Configuration config = new Configuration();
    //PI: private static final AuthenticationManager am = new AuthenticationManager(config);

    //add new VuHID Sender to test methods
    //PI: private static final VUHIDSender vuhidsend = new VUHIDSender();
    private static final VUHIDPortal portal = new VUHIDPortal();

    //UNCOMMENT ROUTINES BELOW TO TEST EACH VUHID TRANSACTION
    //MAKE SURE THAT AN ID IS GENERATED FIRST BEFORE ROUTINE THAT RETIRES/TERMINATES IT IS CALLED
    //IDs ARE HARDCODED IN MANY OF THE RETIRE/TERMINATE/STATUS ROUTINES

    public static void main(String[] args) {

        //section to test getStatusOfID routine
        int temp = 0;
        try {
            //PI: temp = vuhidsend.getStatusOfID("0000000000000009.523079864000000");
            temp = portal.getStatusOfID("0000000000000009.523079864000000");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\nResponse code for check of ID should be 200; is: " + temp);


/*        //section to test getNewOVID routine
        String temp = null;
        try {
            temp = vuhidsend.getNewOVID();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\nResponse from getNewOVID routine: " + temp);*/


/*        //section to test getNewPVID routine
        String temp = null;
        try {
            temp = vuhidsend.getNewPVID("4000000");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\nResponse from getNewPVID routine: " + temp);*/


/*        //section to test retireID routine
        String reason = "PVID was used by CsTheDay only for software testing.";
        String ID = "0000000000000008.023042694000000"; //just generated this in getNewPVID above
        int temp = 0;
        try {
            temp = vuhidsend.retireID(ID, reason );
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("HTTP Response from retireID routine, should be 200: " + temp);*/


//        try {
            // create key and trust managers, then initialize the ssl context with their data
//            SSLSocketFactory factory = am.getSSLSocketFactory();
            // communicate with the server
//            URL url = new URL("https://" + config.getVuhidServerHostName() + "/verify/0000000406190821.350181120000000");
//            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            //OutputStreamWriter  out = null;
            //BufferedReader      in = null;
            //String              responseString;
            //int x;

/* My goal is to start moving all of the following code into the VUHIDSender class.
 * This class should just be a driver that calls methods in VUHIDSender.java. */

//DONE


/********************************************************************************************************
 String contentType = connection.getHeaderField("Content-Type");
 String charset = null;
 for (String param : contentType.replace(" ", "").split(";")) {
 if (param.startsWith("charset=")) {
 charset = param.split("=", 2)[1];
 break;
 }
 }

 if (charset != null) {
 BufferedReader reader = null;
 InputStream response = connection.getInputStream();
 try {
 reader = new BufferedReader(new InputStreamReader(response, charset));
 for (String line; (line = reader.readLine()) != null;) {
 System.out.println(line);
 }
 } finally {
 if (reader != null) try { reader.close(); } catch (IOException logOrIgnore) {}
 }
 } else {
 // It's likely binary content, use InputStream/OutputStream.
 }
 /********************************************************************************************************/

//            System.out.println("DONE");

/*********************************************************************************************************

 connection.setDoOutput(true);
 out = new OutputStreamWriter(connection.getOutputStream());
 out.write("termination_explanation=\"PVID was used by CsTheDay only for software testing.\""); // Remove this for GET requests, or change as needed
 out.close();
 System.out.println("THE RESPONSE CODE IS: " + connection.getResponseCode());

 in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
 while ((responseString = in.readLine()) != null) {
 System.out.println(responseString);
 }
 in.close();
 /*********************************************************************************************************
 InputStream error = ((HttpURLConnection) connection).getErrorStream();
 // This was in the original, and may work just fine (or better?), but I haven't tried it yet...
 while ((x = ((InputStream) connection.getContent()).read()) != -1) {
 System.out.print(new String(new byte[] {(byte) x }));
 }
 /*********************************************************************************************************/

//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }//end main()
}
