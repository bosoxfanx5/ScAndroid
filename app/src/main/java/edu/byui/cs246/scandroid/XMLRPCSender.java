package edu.byui.cs246.scandroid;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by admin on 11/2/16.
 */

public class XMLRPCSender implements Observer {

    ScannerObserver so;

    public InetAddress serverIP;

    public int port = 8000;

    @Override
    public void update(Observable o, Object arg) {

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

    public boolean send() { return false;}  //fail because we can't send things yet
}
