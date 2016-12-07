package edu.byui.cs246.scandroid;

import android.util.Log;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by admin on 11/2/16.
 */

public class Scanner extends Observable {

    Integer delay; //delay in ms
    ArrayList<ArrayList<Scan>> scans = new ArrayList<ArrayList<Scan>>();

    //observers managed by superclass

    public void Scanner() {
        ArrayList<Scan> temp = new ArrayList<Scan>();
        scans = new ArrayList<ArrayList<Scan>>();
        scans.add(temp);
    }

    public Scan scan() { //produces a scan object - scan is a verb here
        if (!scans.isEmpty())
            return scans.get(0).get(0);
        else {
            return null;
        }
    }

    public void beginScanning() {};
    public Scan getScan() {return scans.get(0).get(0);}

    //TODO: List functions - maybe we need another class for the list...
    public void insertSection() {};

    public void insertScan(Scan scan) {
        ArrayList<Scan> temp = new ArrayList();
        temp.add(scan);
        if (!scans.equals(null) && scans.isEmpty()) {
            scans.add(0, temp);
        }
        else {
            scans.get(0).add(0, scan);
        }

        Log.i("Info: ", "Inserting scan." + scans.get(0).get(0).getData());
        setChanged();
        notifyObservers();
    }

    public void     clearList() {}

    public Integer totalScanCount() { return scans.size();} //this needs loop through each sublist
    public Integer listScanCount()  { return scans.get(0).size();}

}