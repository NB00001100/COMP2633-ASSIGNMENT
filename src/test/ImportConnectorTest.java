

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.ImportConnector;

class ImportConnectorTest {

    @Test
    public void test() {

        String testText = "line 1\n"
                + "line 2\n"
                + "\n"
                + "line 4";

        String address = "https://raw.githubusercontent.com/NB00001100/COMP2633-ASSIGNMENT/main/res/TestFile1.txt?token=GHSAT0AAAAAABSXPZGCFGTUTZWJL55HMXWOYSLMLCA";
        String fromFile = ImportConnector.getTextFromURL(address);

        for (int i = 0; i < fromFile.length(); i++) {
            assertEquals(testText.charAt(i), fromFile.charAt(i));
        }
    }
}
