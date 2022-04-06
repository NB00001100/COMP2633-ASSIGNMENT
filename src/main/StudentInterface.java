package main;

import java.io.PrintStream;
import java.util.Scanner;
// This class is the interface for the user who is a student it displays their options and allows them to view their information
public class StudentInterface {

    // This method displays the options and information available to the user who is a student. 
    // The options allows them to view more info about their courses and fees, and allows them to quit the program
    public static boolean student_interface(int user_id) {




        PrintStream output = new PrintStream(System.out);
        Scanner input = new Scanner(System.in);
       

        int options = 0;

        show_student_info(output, user_id);

        options = input.nextInt();

        if(options == 1)
        {
            // shows current courses taken
            User_interface.show_courses(DataStore.getStudentStorage().get(user_id).getCurrentCourses() , output);
        }
        else if( options == 2)
        {
            // show previous courses
            User_interface.show_courses(DataStore.getStudentStorage().get(user_id).getPastCourses(), output);
        }
        else if( options == 3)
        {
            // view outstanding fees
            User_interface.show_fees(DataStore.getStudentStorage().get(user_id).getOutstandingFees(),output);
        }
        else if( options == 4)
        {
            // view paid fees
            User_interface.show_fees(DataStore.getStudentStorage().get(user_id).getPaidFees(),output);

        }
        else if( options == 8)
        {
            input.close();
            output.close();
            return false;
        }

        //input.close();
        //output.close();
        return true;




    }
    // This displays the options and information of user who is a student
    public static void show_student_info(PrintStream output, int user_id)
    {
        output.println();
        output.println();
        output.print(" Name: ");
        output.println(DataStore.getStudentStorage().get(user_id).getName());
        output.println();
        output.print(" Student ID: ");
        output.println(DataStore.getStudentStorage().get(user_id).getStudentID());
        output.println();
        output.print(" Password: ");
        output.println(DataStore.getStudentStorage().get(user_id).getPassword());
        output.println();
        output.print(" Major: ");
        output.println(DataStore.getStudentStorage().get(user_id).getMajor());
        output.println();
        output.print(" GPA: ");
        output.println(DataStore.getStudentStorage().get(user_id).getGpa());
        output.println();
        output.println();
        output.println(" To view current courses enter: --- 1");
        output.println(" To view past courses enter: ------ 2");
        output.println(" To view outstanding fees enter: -- 3");
        output.println(" To view paid fees enter: --------- 4");
        output.println(" To leave enter: ------------------ 8");
        output.println();
        output.print(" Enter here: ");

        return;
    }

    // this prints out a student's info, this method is used by a method iniside of admin action to view a particular
    // students information
    public static void info(PrintStream output, int user_id) {
        output.println();
        output.println();
        output.print(" Name: ");
        output.println(DataStore.getStudentStorage().get(user_id).getName());
        output.println();
        output.print(" Student ID: ");
        output.println(DataStore.getStudentStorage().get(user_id).getStudentID());
        output.println();
        output.print(" Password: ");
        output.println(DataStore.getStudentStorage().get(user_id).getPassword());
        output.println();
        output.print(" Major: ");
        output.println(DataStore.getStudentStorage().get(user_id).getMajor());
        output.println();
        output.print(" GPA: ");
        output.println(DataStore.getStudentStorage().get(user_id).getGpa());
        output.println();
        output.println();
        output.println(" -------------------------------------------------------");
        output.println();
        output.println(" Current courses");
        User_interface.show_courses(DataStore.getStudentStorage().get(user_id).getCurrentCourses() , output);
        output.println();
        output.println();
        output.println(" -------------------------------------------------------");
        output.println();
        output.println(" Previous courses");
        User_interface.show_courses(DataStore.getStudentStorage().get(user_id).getPastCourses(), output);
        output.println();
        output.println();
        output.println(" -------------------------------------------------------");
        output.println();
        output.println(" Outstanding fees");
        User_interface.show_fees(DataStore.getStudentStorage().get(user_id).getOutstandingFees(),output);
        output.println();
        output.println();
        output.println(" -------------------------------------------------------");
        output.println();
        output.println(" Paid fees");
        User_interface.show_fees(DataStore.getStudentStorage().get(user_id).getPaidFees(),output);
        output.println();
        output.println();
    }



}
