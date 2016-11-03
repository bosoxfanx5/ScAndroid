package edu.byui.cs246.scandroid;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 11/2/16.
 */
public class OptionsTest {
    @Test
    public void update() throws Exception {

    }

    @Test
    public void isValidOption(String optionName){
        switch (optionName) {
            case "ipAddress": break;
            default: assert (false);
        }
    }

    @Test
    public void isValidOption(String optionName, String value){
        switch (optionName) {
            case "ipAddress": break;
            default: assert (false);
        }
    }

    @Test
    public void validateOptions(){
        //loop through options and call isValidOption on each one
    }
}