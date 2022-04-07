/************
* DataStorage Class
* This class currently allows for the
* student and admin hashmap storages to be filled
* with the information from the GitHub text file
*
**************/
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;

public  class DataStore {

    private static HashMap<Integer, Student> studentStorage = new HashMap<Integer, Student>();

    private static HashMap<Integer, Admin> adminStorage = new HashMap<Integer, Admin>();



    /*
     * fillStudentStorage:
     * The main method that fills the student hashmap
     *
     *
     *
     */
    public static void fillStudentStorage(String contents) {

        BufferedReader reader = new BufferedReader(new StringReader(contents));
        try {
            reader.mark(50);
            while (reader.readLine() != null) {

                reader.reset();
                String currLine = reader.readLine();
                String [] studentFields = currLine.split(":");
                int id = Integer.parseInt(studentFields[0]);
                String name = studentFields[1];
                String major = studentFields[2];
                double gpa = Double.parseDouble(studentFields[3]);
                String passWord = studentFields[4];

                String [] courseFields = null;


                /*create the current courses array*/
                /***************************************************************/
                currLine = reader.readLine();
                studentFields = currLine.split(":");

                Course[] currCourses = new Course [studentFields.length];

                for (int i = 0; i < studentFields.length; i++) {
                    courseFields = studentFields[i].split(",");
                    currCourses[i] = new Course(courseFields[0], Integer.parseInt(courseFields[1]));
                }

                /*create the past courses array*/
                /*********************************************************/
                currLine = reader.readLine();
                studentFields = currLine.split(":");

                Course[] pastCourse = new Course [studentFields.length];

                for (int i = 0; i < studentFields.length; i++) {
                    courseFields = studentFields[i].split(",");
                    pastCourse[i] = new Course(courseFields[0], Integer.parseInt(courseFields[1]));
                }


                /*create the current fees array*/
                /***********************************************************/
                currLine = reader.readLine();
                studentFields = currLine.split(":");

                Fees[] currFee = new Fees [studentFields.length];

                for (int i = 0; i < studentFields.length; i++) {
                    courseFields = studentFields[i].split(",");
                    currFee[i] = new Fees(courseFields[0], Integer.parseInt(courseFields[1]));
                }

                /*create the overdue fees array*/
                /****************************************************************/
                currLine = reader.readLine();
                studentFields = currLine.split(":");

                Fees[] overDueFee = new Fees [studentFields.length];

                for (int i = 0; i < studentFields.length; i++) {
                    courseFields = studentFields[i].split(",");
                    overDueFee[i] = new Fees(courseFields[0], Integer.parseInt(courseFields[1]));
                }



                /*create new student instance and add to hashmap*/
                Student newStudent = new Student(gpa, name, major, id, passWord,overDueFee,
                        currFee, currCourses, pastCourse);

                studentStorage.put(id, newStudent);



                reader.readLine();
                reader.mark(50);

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


   /*
    * fillAdminStorage
    * the main method which fills the admin storage
    */
    public static void fillAdminStorage(String contents) {

        BufferedReader reader = new BufferedReader(new StringReader(contents));

        try {
            reader.mark(50);
            while (reader.readLine() != null) {

                reader.reset();
                String currLine = reader.readLine();
                String [] adminFields = currLine.split(":");

                int id = Integer.parseInt(adminFields[0]);
                String pass = adminFields[1];

                Admin newAdmin = new Admin(id, pass);
                adminStorage.put(id, newAdmin);

                reader.readLine();
                reader.mark(50);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * findStudent allows for students to be searched
     * and is used in methods in AdminActions
     *
     */
    public static Student findStudent(int id, String name)
    {
        if(studentStorage.containsKey(id) == true )
        {
             return DataStore.getStudentStorage().get(id);
        }

        return null;
    }




    /**
     * addStudentFromAdmin
     * lets the admin add a student as a part of their actions
     */
    public static void addStudentFromAdmin(String major, String password, String name, double gpa, int id, Course [] curr,
            Course [] past, Fees [] outstanding, Fees [] paid)
    {
        Student new_student = new Student(gpa, name, name, id, name, paid, paid, past, past);

        new_student.setName(name);
        new_student.setMajor(major);
        new_student.setGpa(gpa);
        new_student.setPassword(password);
        new_student.setStudentID(id);
        new_student.setCurrentCourses(curr);
        new_student.setPastCourses(past);
        new_student.setOutstandingFees(outstanding);
        new_student.setPaidFees(paid);


    }

    /*
     * puts the student to add in the hashmap
     *
     */
    public static void add_student(Student student_to_be_added)
    {
        studentStorage.put(student_to_be_added.getStudentID(), student_to_be_added);
    }

    /**

      remove a student from the hashmap

    */
    public static void remove_student(int student_id, String Name)
    {
        if(studentStorage.containsKey(student_id)== true &&
                studentStorage.get(student_id).getName().equals(Name)== true)
        {
            studentStorage.remove(student_id);
        }
    }

    /*
     * This method returns a String which contains all the student information
     * in the database in the format used in "StudentFile.txt"
     */
    public static String stringifyStudent() {

        StringBuilder contents = new StringBuilder();

        studentStorage.forEach((k,v) -> {

            contents.append(k + ":"
                    + v.getName() + ":"
                    + v.getMajor() + ":"
                    + v.getGpa() + ":"
                    + v.getPassword() + "\n");

            int counter = 0;
            while (v.getCurrentCourses()[counter] != null) {
                contents.append(v.getCurrentCourses()[counter].getCourseName() + ","
                        + v.getCurrentCourses()[counter].getCourseID() + ":");
                counter++;
            }
            contents.append("\n");

            counter = 0;
            while (v.getPastCourses()[counter] != null) {
                contents.append(v.getPastCourses()[counter].getCourseName() + ","
                        + v.getPastCourses()[counter].getCourseID() + ":");
                counter++;
            }
            contents.append("\n");

            counter = 0;
            while (v.getOutstandingFees()[counter] != null) {
                contents.append(v.getOutstandingFees()[counter].getFeeName() + ","
                        + v.getOutstandingFees()[counter].getFeeAmount() + ":");
                counter++;
            }
            contents.append("\n");

            counter = 0;
            while (v.getPaidFees()[counter] != null) {
                contents.append(v.getPaidFees()[counter].getFeeName() + ","
                        + v.getPaidFees()[counter].getFeeAmount() + ":");
                counter++;
            }
            contents.append("\n\n");
        });

        return contents.toString().trim();
    }

    public static HashMap<Integer, Student> getStudentStorage() {
        return studentStorage;
    }

    public static void setStudentStorage(HashMap<Integer, Student> studentStorage) {
        DataStore.studentStorage = studentStorage;
    }

    public static HashMap<Integer, Admin> getAdminStorage() {
        return adminStorage;
    }

    public static void setAdminStorage(HashMap<Integer, Admin> adminStorage) {
        DataStore.adminStorage = adminStorage;
    }




}
