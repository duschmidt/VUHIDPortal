

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * This class implements a HTTP web server that runs in a seperate thread and  
 * listens for messages from VUHID and then updates an EMPI.
 * @author Teja Pitla
 */
public class VUHID_Listener
{
	//Fields
	private InetSocketAddress addr;
	private HttpServer server;
	
	
	/**
	 * Creates an instance of VUHID Listener
	 * @param port 
	 */
	public VUHID_Listener(int port)
	{
	     this.addr = new InetSocketAddress(port);
	     try
	     {
	    	 this.server = HttpServer.create(addr,0);
	     }
	     catch(Exception e)
	     {
	    	 System.err.println(e.getMessage());
	    	 System.exit(1);
	     }
	     this.server.createContext("/", new RequestHandler());
	     this.server.setExecutor(null);

	}
	
	/**
	 * Creates new thread and runs HTTP web server
	 *  
	 */
	public void listen()
	{
		server.start();
	}
	
	//Handles all HTTP requests to default server directory
    static class RequestHandler implements HttpHandler 
    {
        public void handle(HttpExchange exchange) throws IOException 
        {
        	//Example functionality reads from an index.html file. Replace with proper code. 
            String response = "";

        	BufferedReader in = new BufferedReader(new FileReader("index.html"));
        	String input = "";
        	
        	while((input = in.readLine()) != null)
        	{
        		response = response + input;
        		input = "";
        	}
            
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}
