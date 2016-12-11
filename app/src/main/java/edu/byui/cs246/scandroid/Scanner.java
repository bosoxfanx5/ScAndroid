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
        ArrayList<Scan> temp = new ArrayList<Scan>(); //to store scans
        scans = new ArrayList<ArrayList<Scan>>();
        scans.add(temp);
    }

    //this was to house the scanner, but the API didn't easily allow for that, it now lives in MTA
    public Scan scan() { //produces a scan object - scan is a verb here
        if (!scans.isEmpty())
            return scans.get(0).get(0); //get first item in first list (latest scan)
        else {
            return null;
        }
    }

    //unused stub whose function is now in MTA
    public void beginScanning() {};

    //returns the lastest scanned item
    public Scan getScan() {return scans.get(0).get(0);} //first item in first arraylist

    //unsused sub to insert multiple items
    public void insertSection() {};

    //inserts a single scanned item into the list
    public void insertScan(Scan scan) {
        ArrayList<Scan> temp = new ArrayList(); // list to be inserted
        temp.add(scan);

        //if scans is not noull and is not empty...
        if (!scans.equals(null) && scans.isEmpty()) {
            scans.add(0, temp); //add the temp array to the list
        }
        else {
            scans.get(0).add(0, scan); //otherwise, add the scan to the first arraylist
        }

        Log.i("Info: ", "Inserting scan." + scans.get(0).get(0).getData());
        setChanged(); //signal a change for the observer model
        notifyObservers(); //notify observers
    }

    //stub method for clearing lists
    public void     clearList() {}

    //returns the count of all scans by summing sizes
    public Integer totalScanCount() {
        int count = 0;
        for (ArrayList al : scans) {
            count += al.size();
        }
        return count;
    }

    //returns the count of scans from the latest list
    public Integer listScanCount()  { return scans.get(0).size();}

}