package edu.byui.cs246.scandroid;

import java.util.Observable;
import java.util.Observer;
//import javax.swing.JFormattedTextField; //need to figure out how to import swing

/**
 * Created by admin on 11/2/16.
 */

//unused stub
public class Screen extends Observable implements Observer { //TODO: OptionsObserver, ScannerObserver {

    //JFormattedTextField serverIPTF; //need to import swing
    //observers managed by superclass

    //TODO not sure if this is right...
    OptionsObserver oo;
    ScannerObserver so;

    @Override
    public void update(Observable o, Object arg) {

    }

    public void changeDisplay() {};
    public void changeOptions() {};
}
