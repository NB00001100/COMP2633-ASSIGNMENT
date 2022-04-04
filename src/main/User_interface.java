import java.io.PrintStream;
import java.util.Scanner;

// author Nimrat Brar, add names

public class User_interface {

    private static int user_id = 0;
    private static String user_password = "";

    public static void main(String [] args)
    {
        login_interface();

        return;
    }

    public static void login_interface() {

        PrintStream output = new PrintStream(System.out);
        Scanner input = new Scanner(System.in);


        output.println(" Welcome To KPN University Student Database System ");
        output.println();
        output.println();
        output.println(" Please enter your Login information");
        output.print(" KPN University ID: ");
        try {
        setUser_id(input.nextInt());
        }
        catch(Exception e) {
            System.err.println(" The reading of University ID input was not succesful. ");
            System.err.println(" Please reload the application or Contact Team KPN  ");
        }

        output.print(" Password: ");

        try {
        while(getUser_password().isEmpty())
        setUser_password(input.nextLine());
        }
        catch(Exception e)
        {
            System.err.println(" The reading of password input was not succesful. ");
            System.err.println(" Please reload the application or Contact Team KPN  ");
        }

        input.close();
        login();

        return;


    }
    public static boolean student_interface() {




        PrintStream output = new PrintStream(System.out);
        Scanner input = new Scanner(System.in);

        int look_at_courses = 0;

        show_student_info(output);

        look_at_courses = input.nextInt();

        if(look_at_courses == 1)
       {
           // shows current courses taken
           show_courses(DataStore.getStudentStorage().get(getUser_id()).getCurrentCourses(), output);
       }
       else if(look_at_courses == 2)
       {
           // show previous courses
           show_courses(DataStore.getStudentStorage().get(getUser_id()).getPastCourses(), output);
       }
       else if(look_at_courses == 3)
       {
           // view outstanding fees
           show_fees(DataStore.getStudentStorage().get(getUser_id()).getOutstandingFees(),output);
       }
       else if(look_at_courses == 4)
       {
           // view paid fees
           show_fees(DataStore.getStudentStorage().get(getUser_id()).getPaidFees(),output);

       }
       else if( look_at_courses == 8)
       {
           input.close();
           output.close();
           return false;
       }
        input.close();
        output.close();
        return true;




    }

    public static void login()
    {
        Login user = new Login(); // may have reference problem

        if(user.attemptLogin(user_id, user_password) && user.getUserIsAdmin() == false)
        {
            boolean run = true;
            while(run == true)
            {
                run = student_interface();

            }
        }
        else if(user.attemptLogin(user_id, user_password) && user.getUserIsAdmin() == true)
        {
            // run admin_interface
        }

    }

    public static void show_courses(Course [] courses, PrintStream output)
    {
        int counter = 0;

        while(courses[counter] != null)
        {
            output.println();
            output.println();
            output.print(" Course Name: ");
            output.println(courses[counter].getCourseName());
            output.println();
            output.print(" Course ID: ");
            output.print(courses[counter].getCourseID());


            counter++;

        }

        return;
    }
    public static void show_fees( Fees [] fees1, PrintStream output)
    {
        int counter = 0;

        while( fees1[counter] != null)
        {
            output.println();
            output.println();
            output.print(" Fee Name: ");
            output.println(fees1[counter].getFeeName());
            output.println();
            output.print(" Fee Amount: ");
            output.print(fees1[counter].getFeeAmount());

            counter ++;
        }

        return;
    }

    public static void show_student_info(PrintStream output)
    {
        output.println();
        output.println();
        output.print(" Name: ");
        output.println(DataStore.getStudentStorage().get(getUser_id()).getName());
        output.println();
        output.print(" Student ID: ");
        output.println(DataStore.getStudentStorage().get(getUser_id()).getStudentID());
        output.println();
        output.print(" Major: ");
        output.println(DataStore.getStudentStorage().get(getUser_id()).getMajor());
        output.println();
        output.print(" GPA: ");
        output.println(DataStore.getStudentStorage().get(getUser_id()).getGpa());
        output.println();
        output.println();
        output.println(" To view current courses enter: 1");
        output.println(" To view past courses enter: 2");
        output.println(" To view outstanding fees enter: 3");
        output.println(" To view paid fees enter: 4");
        output.println();
        output.println(" To leave enter: 8 ");
        output.println(" Enter here: ");

        return;

    }


    public static String getUser_password() {
        return user_password;
    }

    public static void setUser_password(String user_password1) {
        user_password = user_password1;
    }

    public static int getUser_id() {
        return user_id;
    }

    public static void setUser_id(int user_id1) {
        user_id = user_id1;
    }

}
