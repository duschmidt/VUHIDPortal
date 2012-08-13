package vuhidtools;

/**
 * Author: Robert Hickey
 * Date: 8/11/12
 * @version 1.1
 * Comments:    Ver 1.0 First version of Peter's work
 *                  1.1 Moved code to validate ID into getStatusID routine of VUHIDSender.java
 *                      Tested with old code here commented out and works as befor
 *
 */
public class VUHIDPortalPrototype {
    private static final Configuration config = new Configuration();
    private static final AuthenticationManager am = new AuthenticationManager(config);

    //add new VuHID Sender to test methods
    private static final VUHIDSender vuhidsend = new VUHIDSender();

    public static void main(String[] args) {

        int temp = 0;
        try {
            temp = vuhidsend.getStatusOfID("0000000406190821.350181120000000");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Response code for check of ID is: " + temp);
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

//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("From", config.getFromHeaderValue());
//            connection.setRequestProperty("User-Agent", config.getUserAgentHeaderValue());
//            connection.setRequestProperty("Host", config.getVuhidServerHostName());
//            connection.setRequestProperty("Accept", "*/*");
//            connection.setRequestProperty("Content-Length", "32");
//            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//
//            connection.setSSLSocketFactory(factory);
//
//            System.out.println("RESPONSE CODE: " + connection.getResponseCode());
//            System.out.println("RESPONSE MESSAGE: " + connection.getResponseMessage());
//            System.out.println("RESPONSE HEADERS:");
//            for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
//                System.out.println("\t" + header.getKey() + ": " + header.getValue());
//            }


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
