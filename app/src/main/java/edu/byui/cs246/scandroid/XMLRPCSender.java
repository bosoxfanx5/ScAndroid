package edu.byui.cs246.scandroid;

import android.util.Log;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import de.timroes.axmlrpc.XMLRPCClient;

import static java.lang.System.exit;

/**
 * Created by admin on 11/2/16.
 */

public class XMLRPCSender implements Observer {

    public String SERVER_SETTINGS = "ServerSettings";

    public String ip = "127.0.0.1";
    public String port = "8000";

    private static XMLRPCSender xmlrpcSender = new XMLRPCSender();
    ScannerObserver so;

//    public InetAddress serverIP;
//    public int port = 8000;

    //XMLRPCClient client = new XMLRPCClient(new URL("http://127.0.0.1" + ":" + port + "/RPC2"));

    private XMLRPCSender() {

    }

    public static XMLRPCSender getInstance() {
        return xmlrpcSender;
    }


    //public XMLRPCSender() throws MalformedURLException {
        //Retrieve settings from Shared Preferences
//        try {
//            SharedPreferences settings = context.getSharedPreferences(SERVER_SETTINGS, 0);
//            String ip = settings.getString("IP", "127.0.0.1"); //ip   - default to 127.0.0.1
//            String port = settings.getString("Port", "8000");      //port - default to 8000
//
//            Log.i("Info:", "IP: " + ip + " and Port: " + port);
//
//            try {
//                //create client using IP address and port numnber
//                client = new XMLRPCClient(new URL("http://" + ip + ":" + port + "/RPC2"));
//            } catch (Exception ex1) {
//                Log.e("Error:", "Could not create client: " + ex1.getMessage());
//                exit(0);
//            }
//
//        } catch (Exception ex2) {
//            Log.e("Error:", "Shared Prferences Not Avialable: " + ex2.getMessage());
//            exit(0);
//        }
    //}

    public XMLRPCSender(String ip, String port) {
        Log.i("Info:", "IP: " + ip + " and Port: " + port);
        this.ip = ip;
        this.port = port;
        try {
            //create client using IP address and port numnber
//            XMLRPCClient client = new XMLRPCClient(new URL("http://" + ip + ":" + port + "/RPC2"));

        } catch (Exception ex1) {
            Log.e("Error:", "Could not create client: " + ex1.getMessage());
            exit(0);
        }
    }

    //override the update method from the Observer class
    @Override
    public void update(Observable o, Object arg) {
        //retrieve scan that triggered the update
        send(((Scanner)o).getScan());
    }

    //verify server reachability
//    public boolean serverIsReachable() {
//        try {
//            //open a socket to the server and attempt connection on the given port
//            try (Socket socket = new Socket()) {
//                socket.connect(new InetSocketAddress(ip, port), 1000);
//            }
//            return true;
//        } catch (IOException ex) {
//            return false;
//        }
//    }

    public boolean send(Scan scan) {
        //log the scan data
        Log.i("Info: ", "scan.getData() = " + scan.getData());
        try {
            //send the scan data to the server calling method "scanalyze"
            XMLRPCClient client = new XMLRPCClient(new URL("http://" + ip + ":" + port + "/RPC2"));
            client.call("scanalyze", scan.getData());
        } catch (Exception ex) {
            //log any exceptions that occur
            Log.i("Exception: ", "send.XMLRPCSender - " + ex.getMessage());
            return false;
        }
        return true;
    }
}
