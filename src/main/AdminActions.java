package main;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * This class implements the actions the administrator is able to do
 */

public class AdminActions {

    private static int student_id = 0;
    private static String name = ""; // name of student

    /*
     * This method prompts the user for the new major to apply to the student.
     * The method then calls a DataStore method to apply the change to the student in the data structure.
     */
    public static void editMajor(PrintStream output, Scanner input) {
        String major = null;
        enterStudentInfo(output, input);
        output.println();
        output.println();
        output.println(" Enter the change in major ");
        output.print(" New major: ");
        major = input.next();
        DataStore.getStudentStorage().get(student_id).setMajor(major);
    }

    /*
     * This method prompts the user to add or remove a student's current courses.
     * The user can select a course to remove or specify the details of a course to add.
     * The method then calls a DataStore method to apply the change to the student in the data structure.
     */
  public static void editCurrentCourses(PrintStream output, Scanner input) {


      int courseIndex = 0;
      Student currStudent = null;
      int option = 0;
      String courseName = null;
      int courseID = 0;

      enterStudentInfo(output, input);


      output.println(" Would you like to add or remove a current course?");
      output.print(" Add: 1");
      output.println();
      output.println(" Remove: 2");
      output.print(" Enter choice: ");
      option = input.nextInt();
      output.println();
      output.println();

      currStudent = DataStore.findStudent(student_id, name);

      int length = currStudent.getCurrentCourses().length;
      Course[] copyCurrCourse = new Course[length];


      if(option == 2) {

          User_interface.show_courses(currStudent.getCurrentCourses(), output);

          output.print(" Enter the course # you would like to change ");
          courseIndex = input.nextInt();

      for (int i = 0, j = 0; i < currStudent.getCurrentCourses().length; i++) {

          if (i != courseIndex) {
              copyCurrCourse[j++] = currStudent.getCurrentCourses()[i];

          }
      }

       copyCurrCourse[length-1] = null;

    }

      if (option == 1)

      {

          User_interface.show_courses(currStudent.getCurrentCourses(), output);

          for (int i = 0, j = 0; i < currStudent.getCurrentCourses().length; i++) {

                  copyCurrCourse[j++] = currStudent.getCurrentCourses()[i];
              }

          output.println(" Enter the course name and ID to add new course ");
          output.println();
          output.print(" Enter course name: ");
          courseName = input.next();
          output.println();
          output.print(" Enter ID of course: ");
          courseID = input.nextInt();
          output.println();

          Course newCourse = new Course(courseName, courseID);

          int counter = 0;

          while ( copyCurrCourse[counter] != null)
          {

              counter++;
          }

          copyCurrCourse[counter] = newCourse;

      }

      currStudent.setCurrentCourses(copyCurrCourse);

    }


  /*
   * This method prompts the user to add or remove a student's previous courses.
   * The user can select a course to remove or specify the details of a course to add.
   * The method then calls a DataStore method to apply the change to the student in the data structure.
   */
    public static void editPreviousCourses(PrintStream output, Scanner input) {

        int courseIndex = 0;
        Student pastStudent = null;
        int option = 0;
        String courseName = null;
        int courseID = 0;

        enterStudentInfo(output, input);


        output.println(" Would you like to add or remove a previous course?");
        output.print(" Add: 1");
        output.println();
        output.println(" Remove: 2");
        output.print(" Enter choice: ");
        option = input.nextInt();
        output.println();
        output.println();

        pastStudent = DataStore.findStudent(student_id, name);

        int length = pastStudent.getPastCourses().length;
        Course[] copyPastCourse = new Course[length];


        if(option == 2) {

            User_interface.show_courses(pastStudent.getPastCourses(), output);

            output.print(" Enter the course # you would like to change ");
            courseIndex = input.nextInt();

        for (int i = 0, j = 0; i < pastStudent.getPastCourses().length; i++) {
            if (i != courseIndex) {
                copyPastCourse[j++] = pastStudent.getPastCourses()[i];
            }
        }

         copyPastCourse[length-1] = null;

      }



        if (option == 1)

        {

            User_interface.show_courses(pastStudent.getPastCourses(), output);

            for (int i = 0, j = 0; i < pastStudent.getPastCourses().length; i++) {

                    copyPastCourse[j++] = pastStudent.getPastCourses()[i];
                }

            output.println(" Enter the course name and ID to add new course ");
            output.println();
            output.print(" Enter course name: ");
            courseName = input.next();
            output.println();
            output.print(" Enter ID of course: ");
            courseID = input.nextInt();
            output.println();

            Course newCourse = new Course(courseName, courseID);

            int counter = 0;

            while ( copyPastCourse[counter] != null)
            {

                counter++;
            }

            copyPastCourse[counter] = newCourse;

        }

        pastStudent.setPastCourses(copyPastCourse);

    }


    /*
     * This method prompts the user for a new GPA to apply to the student.
     * The method then calls a DataStore method to apply the change to the student in the data structure.
     */
    public static void editGpa(PrintStream output, Scanner input) {
        double new_gpa = 0;
        enterStudentInfo(output, input);
        output.println();
        output.println();
        output.println(" Enter change in GPA");
        output.print(" New GPA: ");
        new_gpa = input.nextDouble();
        DataStore.getStudentStorage().get(student_id).setGpa(new_gpa);

    }

    /*
     * This method prompts the user to add or remove a student's outstanding fees.
     * The user can select a fee to remove or specify the details of a fee to add.
     * The method then calls a DataStore method to apply the change to the student in the data structure.
     */
     public static void editOutstandingFees(PrintStream output, Scanner input) {

        int courseIndex = 0;
        Student currStudent = null;
        int option = 0;
        String courseName = null;
        int courseID = 0;

        enterStudentInfo(output, input);


        output.println(" Would you like to add or remove a outstanding fee?");
        output.print(" Add: 1");
        output.println();
        output.println(" Remove: 2");
        output.print(" Enter choice: ");
        option = input.nextInt();
        output.println();
        output.println();

        currStudent = DataStore.findStudent(student_id, name);

        int length = currStudent.getOutstandingFees().length;
        Fees[] copyoutFees = new Fees[length];


        if(option == 2) {

            User_interface.show_fees(currStudent.getOutstandingFees(), output);

            output.print(" Enter the fee # you would like to change ");
            courseIndex = input.nextInt();

        for (int i = 0, j = 0; i < currStudent.getOutstandingFees().length; i++) {
            if (i != courseIndex) {
                copyoutFees[j++] = currStudent.getOutstandingFees()[i];
            }
        }

         copyoutFees[length-1] = null;

      }



        if (option == 1)

        {

            User_interface.show_fees(currStudent.getOutstandingFees(), output);

            for (int i = 0, j = 0; i < currStudent.getOutstandingFees().length; i++) {

                    copyoutFees[j++] = currStudent.getOutstandingFees()[i];
                }

            output.println(" Enter the fee name and amount to add new fee ");
            output.println();
            output.print(" Enter fee name: ");
            courseName = input.next();
            output.println();
            output.print(" Enter amount: ");
            courseID = input.nextInt();
            output.println();

            Fees newCourse = new Fees(courseName, courseID);

            int counter = 0;

            while ( copyoutFees[counter] != null)
            {

                counter++;
            }

            copyoutFees[counter] = newCourse;

        }

        currStudent.setOutstandingFees(copyoutFees);

    }

     /*
      * This method prompts the user to add or remove a student's paid fees.
      * The user can select a fee to remove or specify the details of a fee to add.
      * The method then calls a DataStore method to apply the change to the student in the data structure.
      */
    public static void editFeesPaid(PrintStream output, Scanner input) {

        int courseIndex = 0;
        Student currStudent = null;
        int option = 0;
        String courseName = null;
        int courseID = 0;

        enterStudentInfo(output, input);


        output.println(" Would you like to add or remove a paid fee?");
        output.print(" Add: 1");
        output.println();
        output.println(" Remove: 2");
        output.print(" Enter choice: ");
        option = input.nextInt();
        output.println();
        output.println();

        currStudent = DataStore.findStudent(student_id, name);

        int length = currStudent.getPaidFees().length;
        Fees[] copyEditFees = new Fees[length];


        if(option == 2) {

            User_interface.show_fees(currStudent.getPaidFees(), output);

            output.print(" Enter the fee # you would like to change ");
            courseIndex = input.nextInt();

        for (int i = 0, j = 0; i < currStudent.getPaidFees().length; i++) {
            if (i != courseIndex) {
                copyEditFees[j++] = currStudent.getPaidFees()[i];
            }
        }

         copyEditFees[length-1] = null;

      }



        if (option == 1)

        {

            User_interface.show_fees(currStudent.getPaidFees(), output);

            for (int i = 0, j = 0; i < currStudent.getPaidFees().length; i++) {

                    copyEditFees[j++] = currStudent.getPaidFees()[i];
                }

            output.println(" Enter the fee name and amount to add new fee ");
            output.println();
            output.print(" Enter fee name: ");
            courseName = input.next();
            output.println();
            output.print(" Enter amount: ");
            courseID = input.nextInt();
            output.println();

            Fees newCourse = new Fees(courseName, courseID);

            int counter = 0;

            while ( copyEditFees[counter] != null)
            {

                counter++;
            }

            copyEditFees[counter] = newCourse;

        }

        currStudent.setPaidFees(copyEditFees);




    }


    /*
     * This method prompts the user for the new major to apply to the student.
     * The method then calls a DataStore method to apply the change to the student in the data structure.
     * If the inputed ID is already taken, an error message is printed and the user is returned to the menu.
     */
    public static void editStudentId(PrintStream output, Scanner input) {
        int new_studentId = 0;
        enterStudentInfo(output, input);
        output.println();
        output.println();
        output.println(" Enter change in student ID");
        output.print(" New Student ID: ");
        new_studentId = input.nextInt();
        Student temp = new Student();
        if(!DataStore.getStudentStorage().containsKey(new_studentId))
        {
        temp.setCurrentCourses(DataStore.getStudentStorage().get(student_id).getCurrentCourses());
        temp.setGpa(DataStore.getStudentStorage().get(student_id).getGpa());
        temp.setMajor(DataStore.getStudentStorage().get(student_id).getMajor());
        temp.setName(name);
        temp.setOutstandingFees(DataStore.getStudentStorage().get(student_id).getOutstandingFees());
        temp.setPaidFees(DataStore.getStudentStorage().get(student_id).getPaidFees());
        temp.setPassword(DataStore.getStudentStorage().get(student_id).getPassword());
        temp.setPastCourses(DataStore.getStudentStorage().get(student_id).getPastCourses());
        temp.setStudentID(new_studentId);

        DataStore.getStudentStorage().remove(student_id);
        DataStore.getStudentStorage().put(new_studentId, temp);
        }
        else
        {
            output.println();
            output.println(" Please load this option again, this ID is already in the system");

        }
    }


    /*
     * This method prompts the user for the new password to apply to the student.
     * The method then calls a DataStore method to apply the change to the student in the data structure.
     */
    public static void editStudentPassword(PrintStream output, Scanner input) {
        String new_password = "";
        enterStudentInfo(output, input);
        output.println();
        output.println();
        output.println(" Enter change in pasword");
        output.print(" New Password: ");
        new_password = input.next();
        DataStore.getStudentStorage().get(student_id).setPassword(new_password);
    }

    /*
     * This method will prompt the user for the details of the new student.
     * It will then call a DataStore method to add the student to the data structure.
     */
    public static void addNewStudent(PrintStream output, Scanner input) {

        double gpa = 0.0;
        String major = "";
        String password = "";
        Student new_student = new Student();
        int options = 0;

        output.println();
        output.println();
        output.println(" Enter the following information for the new student");
        output.print(" New student's University ID: ");

        setStudent_id(input.nextInt());
        if(!DataStore.getStudentStorage().containsKey(getStudent_id()))
        {
        output.println();
        output.print(" New student's Name: ");
        setName(input.next() + input.next());
        output.println();
        output.print(" New student's major: ");
        major = input.next();
        output.println();
        output.print(" New student's GPA: ");
        gpa = input.nextDouble();
        output.println();
        output.print(" New student's password: ");
        password = input.next();
        output.println();
        output.print(" To enter current courses enter 2: ");
        options = input.nextInt();
        if (options == 2)
        {

            add_currCourses_for_new_student( output, input,new_student);
        }
        output.println();
        output.println();
        output.print(" To enter oustanding fees enter 3: ");
        options = input.nextInt();
        if( options == 3)
        {
            add_outStanding_fees_for_new_student(output,  input,new_student);

        }


        new_student.setName(getName());
        new_student.setMajor(major);
        new_student.setStudentID(student_id);
        new_student.setGpa(gpa);
        new_student.setPassword(password);

        DataStore.getStudentStorage().put(student_id, new_student);

    }
        else
        {
            output.println();
            output.println(" This University Id already exists please enter a new one");
        }
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

    /*
     * This method will prompt the user for a student to remove from the system.
     * A DataStore method is called to remove the specified student from the data structure.
     */
    public static void removeStudent(PrintStream output, Scanner input) {
        int remove = 0;
        output.println();
        output.println();
        output.println(" Enter the KPN University ID and Student's name you wish to remove from the system");
        output.print(" University ID: ");
        setStudent_id(input.nextInt());
        output.println();
        output.print(" Student's Name: ");
        setName(input.next() + input.next());
        output.println();
        output.println();
        output.println(" To continue the removal of student enter: 1");
        output.println(" To not continue with the removal of the student enter: 2");
        output.print(" Continue?: ");
        remove = input.nextInt();

        if (remove == 1) {
            DataStore.getStudentStorage().remove(student_id);
        }

    }

    public static void view_student_info(PrintStream output, Scanner input) {
        enterStudentInfo(output, input);
        StudentInterface.info(output, student_id);
    }

    /*
     * A helper function used by methods of this class to prompt the user for the student's ID and name
     * student_id and name are set to the inputed values
     */
    public static void enterStudentInfo(PrintStream output, Scanner input) {
        output.println();
        output.println();
        output.println(" Enter the KPN University ID and Student's name");
        output.print(" University ID: ");
        setStudent_id(input.nextInt());
        output.println();
        output.print(" Student's Name: ");
        setName(input.next() + input.next());
    }

    /*
     * A helper function used by addNewStudent to prompt the user for courses to add to the student
     * These courses are added to the inputed student object
     */
    public static void add_currCourses_for_new_student(PrintStream output, Scanner input, Student new_student)
    {
        int continue_adding = 1;
        int counter = 0;

        while (continue_adding == 1 && counter < new_student.getCurrentCourses().length) {
            String courseName = "";
            int courseId = 0;
            output.println();
            output.println();
            output.print(" Enter course name: ");
            courseName = input.next();
            output.println();
            output.print(" Enter Course ID: ");
            courseId = input.nextInt();
            output.println();
            output.println(" To stop adding current courses enter: 2");
            output.println(" To continue adding to current courses enter: 1");
            output.print(" Enter here: ");
            continue_adding = input.nextInt();
            Course temp = new Course(courseName, courseId);
            new_student.getCurrentCourses()[counter] = temp;
            counter++;
        }
        return;
    }

    /*
     * A helper function used by addNewStudent to prompt the user for fees to add to the student
     * These fees are added to the inputed student object
     */
    public static void add_outStanding_fees_for_new_student(PrintStream output, Scanner input,Student new_student)
    {

        int continue_adding = 1;
        int counter = 0;

        while (continue_adding == 1 && counter < new_student.getOutstandingFees().length) {
            String feeName = "";
            int feeAmount = 0;
            output.println();
            output.println();
            output.print(" Enter Fee name: ");
            feeName = input.next();
            output.println();
            output.print(" Enter Fee amount: ");
            feeAmount = input.nextInt();
            output.println();
            output.println(" To stop adding to outstanding  fees enter: 2");
            output.println(" To continue adding to outstanding fees enter: 1");
            output.print(" Enter here: ");
            continue_adding = input.nextInt();
            Fees temp = new Fees(feeName, feeAmount);
            new_student.getOutstandingFees()[counter] = temp;
            counter++;
        }


    }




}


