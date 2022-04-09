package main;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ImportConnectorTest {

    @Test
    public void valid_address() {
        String testText = "line 1\n"
                + "line 2\n"
                + "\n"
                + "line 4";

        String address = "File:res\\test.txt";
        String fromFile = ImportConnector.getTextFromURL(address);

        for (int i = 0; i < fromFile.length(); i++) {
            assertEquals(testText.charAt(i), fromFile.charAt(i));
        }
    }

    @Test
    public void invalid_address() {
        String address = "File:invalid";
        String fromFile = ImportConnector.getTextFromURL(address);
        assertEquals(null, fromFile);
    }
}
