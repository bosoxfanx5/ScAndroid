package edu.byui.cs246.scandroid;

import org.junit.Test;

/**
 * Created by brooksrobison on 11/2/16.
 */
public class ScanTest {
    @Test
    public void scan() throws Exception {



    }

    @Test
    public void isValidSymbology() {
        Scan scan = new Scan();
        switch (scan.symbology) {
            case "EAN-13":
                break;
            case "EAN-8":
                break;
            case "UPC-A":
                break;
            case "UPC-E":
                break;
            case "Code-39":
                break;
            case "Code-93":
                break;
            case "Code-128":
                break;
            case "ITF":
                break;
            case "Codabar":
                break;
            case "QR Code":
                break;
            case "Data Matrix":
                break;
            case "PDF-417":
                break;
            case "AZTEC":
                break;
            default:
                assert (false);
        }
    }

}