

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

        String address = "https://raw.githubusercontent.com/NB00001100/COMP2633-ASSIGNMENT/main/res/StudentFile.txt?token=GHSAT0AAAAAABSXPZGDRO7VKQ7K42ACNMEMYSLQDUQ";
        String fromFile = ImportConnector.getTextFromURL(address);
        System.out.println(fromFile);

        for (int i = 0; i < fromFile.length(); i++) {
            assertEquals(testText.charAt(i), fromFile.charAt(i));
        }
    }
}
