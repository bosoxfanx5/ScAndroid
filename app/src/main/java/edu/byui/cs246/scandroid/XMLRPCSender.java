package edu.byui.cs246.scandroid;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.android.gms.samples.vision.face.multitracker.R;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutionException;

import de.timroes.axmlrpc.XMLRPCClient;

import static android.app.PendingIntent.getActivity;
import static java.lang.System.exit;

/**
 * Created by admin on 11/2/16.
 */

public class XMLRPCSender implements Observer {

    public String SERVER_SETTINGS = "ServerSettings";

    ScannerObserver so;

    public InetAddress serverIP;
    public int port = 8000;

    XMLRPCClient client = new XMLRPCClient(new URL("http://127.0.0.1" + ":" + port + "/RPC2"));

    //creates default sender
    public XMLRPCSender(Context context) throws MalformedURLException { }

    //creates a new sender using ip and port
    public XMLRPCSender(String ip, String port) throws MalformedURLException {
            Log.i("Info:", "IP: " + ip + " and Port: " + port);

            try {
                //create client using IP address and port numnber
                client = new XMLRPCClient(new URL("http://" + ip + ":" + port + "/RPC2"));
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
    public boolean serverIsReachable() {
        try {
            //open a socket to the server and attempt connection on the given port
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(serverIP.toString(), port), 1000);
            }
            return true; //server is reachable
        } catch (IOException ex) {
            return false; //server is not reachable
        }
    }

    //sends scanned barcode to the server
    public boolean send(Scan scan) {
        //log the scan data
        Log.i("Info: ", "scan.getData() = " + scan.getData());
        try {
            //send the scan data to the server calling method "scanalyze"
            client.call("scanalyze", scan.getData());
        } catch (Exception ex) {
            //log any exceptions that occur
            Log.i("Exception: ", "send.XMLRPCSender - " + ex.getMessage());
            return false; //bad send
    }
        return true; //good send
    }
}
