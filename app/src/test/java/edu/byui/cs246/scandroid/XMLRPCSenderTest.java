package edu.byui.cs246.scandroid;

import org.junit.Test;

/**
 * Created by brooksrobison on 11/2/16.
 */
public class XMLRPCSenderTest {


    @Test
    public void update() throws Exception {

    }

    @Test
    public void checkDestination() {
        XMLRPCSender sender = new XMLRPCSender();
        assert(sender.serverIsReachable());
    }



}