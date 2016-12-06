package edu.byui.cs246.scandroid;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Exchanger;

import de.timroes.axmlrpc.XMLRPCClient;

/**
 * Created by admin on 11/2/16.
 */

public class XMLRPCSender implements Observer {

    ScannerObserver so;

    public InetAddress serverIP;

    public int port = 8000;

    XMLRPCClient client;

    public XMLRPCSender() {
        try {
            client = new XMLRPCClient(new URL("10.0.0.15" + ":" + port));
        } catch (Exception ex) {

        }
    }

    @Override
    public void update(Observable o, Object arg) {
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
        try {
            client.call("scanalyze", scan);
        } catch (Exception ex) {

    }

        return false;

    }  //fail because we can't send things yet
}
