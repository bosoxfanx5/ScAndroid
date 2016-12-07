package edu.byui.cs246.scandroid;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by admin on 11/2/16.
 */

public class Scan {

    private String symbology = "";
    private String data = "";
    private String timestamp = "";

    public Scan() {setTimestamp();}

    public Scan(String data) {
        this.data = data;
        setTimestamp();
    } //constructor - scan is used here as a noun

    public Scan(String data, String symbology) {
        this.data = data;
        this.symbology = symbology;
        setTimestamp();
    }

    public String getData()      { return data; }
    public String getSymbology() { return symbology; }
    public String getTimestamp() { return timestamp; }

    private void setTimestamp() {
        this.timestamp = new SimpleDateFormat("yyyyMMdd.HHmmss").format(Calendar.getInstance().getTime());
    }
}
