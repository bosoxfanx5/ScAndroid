package edu.byui.cs246.scandroid;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by admin on 11/2/16.
 */

//class for storing a single scan
public class Scan {

    private String symbology = ""; //type of barcode, if available
    private String data      = ""; //the actual data represented by the barcode
    private String timestamp = ""; //a timestamp indicating when the barcode was scanned

    //init the scan setting only the timestamp
    public Scan() {setTimestamp();}

    //init the scan using a string for data and generate a timestamp
    public Scan(String data) {
        this.data = data;
        setTimestamp();
    } //constructor - scan is used here as a noun

    //init the scan using strings for data and symbology and generate a timestamp
    public Scan(String data, String symbology) {
        this.data = data;
        this.symbology = symbology;
        setTimestamp();
    }

    //getters for data, symbology and timestamp
    public String getData()      { return data; }
    public String getSymbology() { return symbology; }
    public String getTimestamp() { return timestamp; }

    //private setter for timestamp
    private void setTimestamp() {
        this.timestamp = new SimpleDateFormat("yyyyMMdd.HHmmss").format(Calendar.getInstance().getTime());
    }
}
