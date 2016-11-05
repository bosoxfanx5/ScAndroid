package edu.byui.cs246.scandroid;

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
        return new Scan();
    }

    public void beginScanning() {};
    public Scan getScan() {return new Scan();}

    //TODO: List functions - maybe we need another class for the list...
    public void insertSection() {};
    public void    insertScan() {};
    public void     clearList() {};
    public Integer totalScanCount() { return scans.size();} //this needs loop through each sublist
    public Integer listScanCount()  { return scans.get(0).size();}

}
