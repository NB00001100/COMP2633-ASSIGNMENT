package main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class StudentInterfaceTest {

    @Test
    void printInfo() throws FileNotFoundException {
        String contents = ImportConnector.getTextFromURL("File:res\\StudentFile.txt");
        DataStore.fillStudentStorage(contents);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        StudentInterface.show_student_info(System.out, 200000);

        String output = "\r\n"
                + "\r\n"
                + " Name: first last0\r\n"
                + "\r\n"
                + " Student ID: 200000\r\n"
                + "\r\n"
                + " Password: KPN\r\n"
                + "\r\n"
                + " Major: ComputerScience\r\n"
                + "\r\n"
                + " GPA: 10.0\r\n"
                + "\r\n"
                + "\r\n"
                + " To view current courses enter: --- 1\r\n"
                + " To view past courses enter: ------ 2\r\n"
                + " To view outstanding fees enter: -- 3\r\n"
                + " To view paid fees enter: --------- 4\r\n"
                + " To leave enter: ------------------ 8\r\n"
                + "\r\n"
                + " Enter here: ";
        assertEquals(output , outContent.toString());
    }
}
