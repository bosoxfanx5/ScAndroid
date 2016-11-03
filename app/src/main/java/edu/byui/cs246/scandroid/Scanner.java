package edu.byui.cs246.scandroid;

import java.util.Observable;

/**
 * Created by admin on 11/2/16.
 */

public class Scanner extends Observable {

    public void Scanner() {}

    public Scan scan() {
        return new Scan();

    }
}
