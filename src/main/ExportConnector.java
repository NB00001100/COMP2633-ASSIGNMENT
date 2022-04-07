package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

/*
 * This class handles writing (and overwriting) files
 */

public class ExportConnector {

    /*
     * This method takes String contents and writes it to the file FileAddress.
     * FileAddress should be a path which also includes the name of the file itself.
     * FileAddress should be in URL format; for local files, use the prefix ""File:"
     */
    public static Boolean uploadToGithub (String contents, String fileAddress) {

        try {
            URL url = new URL(fileAddress);

            File myObj = new File(url.getPath());
            if (myObj.exists()) {
                myObj.delete();
            }
            myObj.createNewFile();

            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write(contents);
            myWriter.close();

            return true;

        } catch (IOException e) {
            System.err.println("An error occurred white writing file to: " + fileAddress);
            e.printStackTrace();

            return false;
        }
    }
}
