

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

        String address = "File:\\C:\\Users\\kusha\\OneDrive\\Documents\\GitHub\\COMP2633-ASSIGNMENT\\res\\TestFile1.txt";
        String fromFile = ImportConnector.getTextFromURL(address);
        System.out.println(testText);
        System.out.println("----");
        System.out.println(fromFile);
        System.out.println("----");

        for (int i = 0; i < fromFile.length(); i++) {
            System.out.println(i);
            assertEquals(testText.charAt(i), fromFile.charAt(i));
        }
    }
}
