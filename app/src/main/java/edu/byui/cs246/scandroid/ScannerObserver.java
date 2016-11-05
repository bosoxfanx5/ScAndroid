package edu.byui.cs246.scandroid;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by admin on 11/2/16.
 */

public class ScannerObserver implements Observer {

    Scan scan;         //this is what we had in the UML, but...
    //Scanner scanner; //not sure if we should be using scan or scanner here.

    @Override
    public void update(Observable o, Object arg) {

    }
}
