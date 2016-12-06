package edu.byui.cs246.scandroid;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.Observable;
import java.util.ArrayList;

/**
 * Created by admin on 11/2/16.
 */

public class Scanner extends Observable {

    Integer delay; //delay in ms
    ArrayList<ArrayList<Scan>> scans;

    //observers managed by superclass

    public void Scanner() {}

    public Scan scan() { //produces a scan object - scan is a verb here
        if (scans.size() > 1)
            return scans.get(0).get(0);
        else {
            return null;
        }
    }

    public void beginScanning() {};
    public Scan getScan() {return new Scan();}

    //TODO: List functions - maybe we need another class for the list...
    public void insertSection() {};

    public void insertScan(Scan scan) {
        ArrayList<Scan> temp = new ArrayList();
        temp.add(scan);
        if (scans.size() < 1) {
            scans.add(0, temp);
        }
        else {
            scans.get(0).add(0, scan);
        }

        Log.i("Info: ", "Inserting scan.");

        notifyObservers();
    }

    public void     clearList() {}

    public Integer totalScanCount() { return scans.size();} //this needs loop through each sublist
    public Integer listScanCount()  { return scans.get(0).size();}

}