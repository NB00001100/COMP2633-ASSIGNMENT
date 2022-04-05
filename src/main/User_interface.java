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


    public static void login()
    {
        Login user = new Login();

        if(user.attemptLogin(user_id, user_password) && user.getUserIsAdmin() == false) // checks if login was successful and if the information entered is that of a student
        {
            boolean run = true;

            while(run == true)
            {
                run = StudentInterface.student_interface(user_id);

            }
        }
        else if(user.attemptLogin(user_id, user_password) && user.getUserIsAdmin() == true) // checks if login was successful and if the information entered is that of a administrator
        {
            boolean run = true;

            while(run == true)
            {
                run = AdminInterface.Admin_interface();
            }

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
