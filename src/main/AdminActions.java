package main;
import java.io.PrintStream;
import java.util.Scanner;

public class AdminActions {

    private static int student_id = 0;
    private static String name = "";

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

    public static void editCurrentCourses(PrintStream output, Scanner input) {


      int courseIndex = 0;
      Student currStudent = null;
      int option = 0;
      String courseName = null;
      int courseID = 0;

      enterStudentInfo(output, input);


      output.println("Would you like to add or remove a current course?");
      output.print("Add: 1");
      output.println();
      output.println("Remove: 2");
      output.print(" Enter choice: ");
      option = input.nextInt();
      output.println();
      output.println();

      currStudent = DataStore.findStudent(student_id, name);

      courseIndex = input.nextInt();
      int length = currStudent.getCurrentCourses().length;
      Course[] copyCurrCourse = new Course[length];


      if(option == 2) {

          User_interface.show_courses(currStudent.getCurrentCourses(), output);

          output.println(" Enter the course # you would like to change ");
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


    public static void editPreviousCourses(PrintStream output, Scanner input) {
        // remove from array and shift

    }

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

    public static void editOutstandingFees(PrintStream output, Scanner input) {

    }

    public static void editFeesPaid(PrintStream output, Scanner input) {
        // remove from array and shift

    }

    public static void editStudentId(PrintStream output, Scanner input) {

        int new_studentId = 0;
        enterStudentInfo(output, input);
        output.println();
        output.println();
        output.println(" Enter change in student ID");
        output.print(" New Student ID: ");
        new_studentId = input.nextInt();
        Student temp = new Student();
    }

    public static void editStudentPassword(PrintStream output, Scanner input) {
        String new_password = null;
        enterStudentInfo(output, input);
        output.println();
        output.println();
        output.println(" Enter change in pasword");
        output.print(" New Password: ");
        new_password = input.next();
        DataStore.getStudentStorage().get(student_id).setPassword(new_password);
    }

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
        setName(input.next());
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

    public static void removeStudent(PrintStream output, Scanner input) {
        int remove = 0;
        output.println();
        output.println();
        output.println(" Enter the KPN University ID and Student's name you wish to remove from the system");
        output.print(" University ID: ");
        setStudent_id(input.nextInt());
        output.println();
        output.print(" Student's Name: ");
        setName(input.next());
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
            new_student.getCurrentCourses()[counter].setCourseName(courseName);
            new_student.getCurrentCourses()[counter].setCourseID(courseId);
            counter++;
        }
        return;
    }
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
            new_student.getOutstandingFees()[counter].setFeeName(feeName);
            new_student.getOutstandingFees()[counter].setFeeAmount(feeAmount);
            counter++;
        }


    }




}


