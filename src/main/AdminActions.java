import java.io.PrintStream;
import java.util.Scanner;

public class AdminActions {
  
  // might make a method which asks for id and and name to reduce code duplication
  // if you read this implement the other methods in this class.

    public static void editMajor(PrintStream output, Scanner input)
    {
        String name = null;
        int student_id = 0;
        String major = null;
        Student majorChanged = null;
        output.println();
        output.println();
        output.println(" Enter the KPN University ID and Student's name");
        output.print(" University ID: ");
        student_id = input.nextInt();
        output.println();
        output.print(" Student's Name: ");
        name = input.nextLine();
        output.println();
        output.println();
        output.println(" Enter the change in major ");
        output.print(" New major: ");
        major = input.nextLine();
        majorChanged = DataStore.findStudent(student_id, name);
        majorChanged.setMajor(major);
        DataStore.getStudentStorage().replace(student_id, majorChanged);

    }

    public static void editCurrentCourses(PrintStream output, Scanner input)
    {

    }

    public static void editPreviousCourses(PrintStream output, Scanner input)
    {

    }
    public static void editGpa(PrintStream output, Scanner input)
    {

    }
    public static void editOutstandingFees(PrintStream output, Scanner input)
    {

    }
    public static void editFeesPaid(PrintStream output, Scanner input)
    {

    }
    public static void editStudentId(PrintStream output, Scanner input)
    {

    }
    public static void editStudentPassword(PrintStream output, Scanner input)
    {

    }
    public static void addStudent(PrintStream output, Scanner input)
    {

    }
    public static void removeStudent(PrintStream output, Scanner input)
    {

    }


}
