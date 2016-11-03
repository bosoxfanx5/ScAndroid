package edu.byui.cs246.scandroid;

/**
 * Created by admin on 11/2/16.
 */

public class Message {

    String message;

    public String getMessage(){
        return message;
    }

    public void setMessage(String in){
        message = in;
    }

    public boolean validateMessage() {
        return false;
    }
}
