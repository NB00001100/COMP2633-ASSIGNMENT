package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportConnector {

    public static Boolean uploadToGithub (String contents, String fileAddress) {

        try {

            File myObj = new File(fileAddress);
            myObj.delete();
            myObj.createNewFile();

            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write(contents);
            myWriter.close();

            return true;

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

            return false;
        }
    }
}
