import java.io.PrintStream;
import java.util.Scanner;

public class AdminActions {

    private static int student_id = 0;
    private static String name = "";


    public static void editMajor(PrintStream output, Scanner input)
    {
        String major = null;
        Student majorChanged = null;
        enterStudentInfo(output,input);
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
          // remove from array and shift

    }

    public static void editPreviousCourses(PrintStream output, Scanner input)
    {
          // remove from array and shift

    }
    public static void editGpa(PrintStream output, Scanner input)
    {
        

    }
    public static void editOutstandingFees(PrintStream output, Scanner input)
    {
          // remove from array and shift

    }
    public static void editFeesPaid(PrintStream output, Scanner input)
    {
        // remove from array and shift
 
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
    public static void enterStudentInfo(PrintStream output, Scanner input)
    {
        output.println();
        output.println();
        output.println(" Enter the KPN University ID and Student's name");
        output.print(" University ID: ");
        setStudent_id(input.nextInt());
        output.println();
        output.print(" Student's Name: ");
        setName(input.nextLine());
    }

    public static int getStudent_id() {
        return student_id;
    }

    public static void setStudent_id(int student_id) {
        AdminActions.student_id = student_id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        AdminActions.name = name;
    }




}
