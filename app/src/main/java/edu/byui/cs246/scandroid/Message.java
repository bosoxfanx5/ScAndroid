package edu.byui.cs246.scandroid;

/**
 * Created by admin on 11/2/16.
 */

//Unused for now, this was handled by AXMLRPC
public class Message {

    String message;    //the message to send to the server
    Scan scan;         //the scan to send
    Scan transformer;  //a mutator to transform the barcode in a particular way

    //getter and setter for the message
    public String getMessage(){
        return message;
    }
    public void setMessage(String in){
        message = in;
    }

    //a validator to ensure the message is well formed
    public boolean validateMessage() {
        return false;
    }
}
