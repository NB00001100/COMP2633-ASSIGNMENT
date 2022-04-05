import java.io.PrintStream;
import java.util.Scanner;

public class AdminActions {

    private static int student_id = 0;
    private static String name = "";

    public static void editMajor(PrintStream output, Scanner input) {
        String major = null;
        Student majorChanged = null;
        enterStudentInfo(output, input);
        output.println();
        output.println();
        output.println(" Enter the change in major ");
        output.print(" New major: ");
        major = input.nextLine();
        majorChanged = DataStore.findStudent(student_id, name);
        majorChanged.setMajor(major);
        DataStore.getStudentStorage().replace(student_id, majorChanged);

    }

    public static void editCurrentCourses(PrintStream output, Scanner input) {
        // remove from array and shift

    }

    public static void editPreviousCourses(PrintStream output, Scanner input) {
        // remove from array and shift

    }

    public static void editGpa(PrintStream output, Scanner input) {
        float new_gpa = 0;
        Student gpaChanged = null;
        enterStudentInfo(output, input);
        output.println();
        output.println();
        output.println(" Enter change in GPA");
        output.print(" New GPA: ");
        new_gpa = input.nextFloat();
        gpaChanged = DataStore.findStudent(student_id, name);
        gpaChanged.setGpa(new_gpa);
        DataStore.getStudentStorage().replace(student_id, gpaChanged);

    }

    public static void editOutstandingFees(PrintStream output, Scanner input) {
        // remove from array and shift

    }

    public static void editFeesPaid(PrintStream output, Scanner input) {
        // remove from array and shift

    }

    public static void editStudentId(PrintStream output, Scanner input) {

        int new_studentId = 0;
        Student IdChanged = null;
        enterStudentInfo(output, input);
        output.println();
        output.println();
        output.println(" Enter change in student ID");
        output.print(" New Student ID: ");
        new_studentId = input.nextInt();
        IdChanged = DataStore.findStudent(new_studentId, name);
        IdChanged.setStudentID(new_studentId);
        DataStore.getStudentStorage().replace(student_id, IdChanged);

    }

    public static void editStudentPassword(PrintStream output, Scanner input) {
        String new_password = null;
        Student passwordChanged = null;
        enterStudentInfo(output, input);
        output.println();
        output.println();
        output.println(" Enter change in pasword");
        output.print(" New Password: ");
        new_password = input.nextLine();
        passwordChanged = DataStore.findStudent(student_id, name);
        passwordChanged.setPassword(new_password);
        DataStore.getStudentStorage().replace(student_id, passwordChanged);
    }

    public static void addStudent(PrintStream output, Scanner input) {

    }

    public static void removeStudent(PrintStream output, Scanner input) {

    }

    public static void view_student_info(PrintStream output, Scanner input) {
        enterStudentInfo(output, input);
        StudentInterface.student_interface(student_id);
    }

    public static void enterStudentInfo(PrintStream output, Scanner input) {
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
