import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author Kushal
 *
 * This class implements methods to access a text file at the specified URL and return its contents in a String.
 *
 */
public abstract class ImportConnector {

    /**
     *
     * @param address
     * @return String
     */
    public static String getTextFromURL(String address) {

        try {

            URL url = new URL(address);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder contents = new StringBuilder();

            String currLine;
            while ((currLine = in.readLine()) != null) {
                contents.append(currLine);
                contents.append(System.lineSeparator());
            }

            return contents.toString();

        } catch(IOException ex) {
            System.err.println("Error occured while accessing or reading file at address: " + address);
            return null;
        }

    }
}
