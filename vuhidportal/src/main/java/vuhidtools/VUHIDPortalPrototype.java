/* VUHIDPortalPrototype.java: A very fragile first attempt at communicating with testid.vuhid.org. Very much of this is hard-coded, and the code still needs lots of work (maybe it can be simplified?), but all the basic functionality is present. This program requires both "GPII-CA.keystore" and "PSU-VUHID-Portal.keystore" to be in the "Certificates" directory, within the current working directory; (I have the keystores set to permissions 644, but I'm not sure it matters.) Compile as per usual, with "javac -g VUHIDPortalPrototype.java", and run with "java VUHIDPortalPrototype". If you want LOTS of debugging output, add the flag "-Djavax.net.debug=all".

I copied this almost entirely from http://javasecurity.wikidot.com/example-item-1, but also integrated a few lines from http://denistek.blogspot.com/2010/05/mutual-authentication-with-client.html and from http://stackoverflow.com/questions/2793150/how-to-use-java-net-urlconnection-to-fire-and-handle-http-requests into the "doItAll()" method. */

package vuhidtools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.List;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;

public class VUHIDPortalPrototype 
{
    private static final Configuration config = new Configuration();
    private static final AuthenticationManager am = new AuthenticationManager(config);

    public static void main(String[] args) {
        try {
            // create key and trust managers, then initialize the ssl context with their data
            SSLSocketFactory    factory = am.getSSLSocketFactory();
            // communicate with the server
            URL                 url = new URL("https://" + config.getVuhidServerHostName() + "/verify/0000000406190821.350181120000000");
            HttpsURLConnection  connection = (HttpsURLConnection) url.openConnection();

            //OutputStreamWriter  out = null;
            //BufferedReader      in = null;
            //String              responseString;
            //int x;

/* My goal is to start moving all of the following code into the VUHIDSender class.
 * This class should just be a driver that calls methods in VUHIDSender.java. */
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

            /* copied from http://exampledepot.com/egs/java.net/GetHeaders.html */
            // List all the response headers from the server.
            for (int i = 0; ; i++) {
                String headerName = connection.getHeaderFieldKey(i);
                String headerValue = connection.getHeaderField(i);

                if (headerName == null && headerValue == null) {
                    // No more headers
                    break;
                }
                if (headerName == null) {
                    // The header value contains the server's HTTP version
                }
            }
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
            System.out.println("DONE");
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

