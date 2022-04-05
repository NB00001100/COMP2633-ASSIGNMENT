package main;

import java.io.PrintStream;
import java.util.Scanner;

public class AdminInterface {

    public static boolean Admin_interface() {

        PrintStream output = new PrintStream(System.out);
        Scanner input = new Scanner(System.in);

        int options_value = 0;

        show_admin_options(output);

        options_value = input.nextInt();

        if (options_value == 1) {
            AdminActions.editMajor(output, input);

        } else if (options_value == 2) {
            AdminActions.editCurrentCourses(output, input);
        } else if (options_value == 3) {
            AdminActions.editPreviousCourses(output, input);
        } else if (options_value == 4) {
            AdminActions.editGpa(output, input);

        } else if (options_value == 5) {
            AdminActions.editOutstandingFees(output, input);
        } else if (options_value == 6) {
            AdminActions.editFeesPaid(output, input);
        } else if (options_value == 7) {
            AdminActions.editStudentId(output, input);

        } else if (options_value == 8) {
            AdminActions.editStudentPassword(output, input);
        } else if (options_value == 9) {
            AdminActions.addStudent(output, input);
        } else if (options_value == 10) {
            AdminActions.removeStudent(output, input);
        } else if (options_value == 11) {

            AdminActions.view_student_info(output, input);

        } else if (options_value == 12) {
            output.close();
            input.close();
            return false;

        }

        output.close();
        input.close();
        return true;

    }

    public static void show_admin_options(PrintStream output) {
        output.println();
        output.println();
        output.println(" Welcome to The administration interface ");
        output.println();
        output.println();
        output.println(" To edit major of a student enter: 1");
        output.println(" To edit current courses of a student enter: 2");
        output.println(" To edit previous courses of a student enter: 3");
        output.println(" To edit GPA of a student enter: 4");
        output.println(" To edit Outstanding fees enter: 5");
        output.println(" To edit fees paid enter: 6");
        output.println(" To edit student id enter: 7");
        output.println(" To edit student password enter 8 :");
        output.println(" To add a student to the Student Database System enter: 9");
        output.println(" To remove a student from the Student DataBase System enter: 10 ");
        output.println(" To view a Student's information enter: 11");
        output.println(" To quit enter: 12");
        output.println();
        output.print(" Enter here: ");
        return;

    }

}
