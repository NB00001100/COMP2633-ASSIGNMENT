package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author Kushal
 *
 * This class implements a method to access a text file at the specified URL and return its contents in a String.
 *
 */
public abstract class ImportConnector {

    /*
     * This method reads a text file at the inputed address (String address) and returns its contents in a String
     * String address should be a path that also includes the name of the file accessed
     * String address should be in URL format; for local files, use the prefix ""File:"
     */
    public static String getTextFromURL(String address) {

        try {

            URL url = new URL(address);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder contents = new StringBuilder();

            String currLine;
            while ((currLine = in.readLine()) != null) {
                contents.append(currLine);
                contents.append("\n");
            }
            contents.append("\0");

            return contents.toString().trim();

        } catch(IOException ex) {
            System.err.println("Error occured while accessing or reading file at address: " + address);
            return null;
        }

    }
}
