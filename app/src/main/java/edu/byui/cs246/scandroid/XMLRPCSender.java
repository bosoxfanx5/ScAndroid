package edu.byui.cs246.scandroid;

import android.util.Log;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import de.timroes.axmlrpc.XMLRPCClient;

/**
 * Created by admin on 11/2/16.
 */

public class XMLRPCSender implements Observer {

    ScannerObserver so;

    public InetAddress serverIP;

    public int port = 8000;

    XMLRPCClient client = new XMLRPCClient(new URL("http://127.0.0.1" + ":" + port + "/RPC2"));

    public XMLRPCSender() throws MalformedURLException {
        try {
            client = new XMLRPCClient(new URL("http://10.0.0.15" + ":" + port + "/RPC2"));
        } catch (Exception ex) {

        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Log.i("Update: ", "Update Called");
        send(((Scanner)o).getScan());
    }

    public boolean serverIsReachable() {
        try {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(serverIP.toString(), port), 1000);
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean send(Scan scan)
    {
        Log.i("Info ", "scan.getData() = " + scan.getData());
        try {
            client.call("scanalyze", scan.getData());
        } catch (Exception ex) {
            Log.i("Info: ", "Send Log: " + ex.getMessage());

    }
        Log.i("Info: ", "Scanning");

        return false;

    }
}
