package edu.byui.cs246.scandroid;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by admin on 11/2/16.
 */

//unused stub
public class Options extends Observable implements Observer {
    String serverIP;
    Integer port;
    //observers managed by observable superclass

    @Override
    public void update(Observable o, Object arg) {

    }

    //public generateXMLRPCSender() {} //???
}
