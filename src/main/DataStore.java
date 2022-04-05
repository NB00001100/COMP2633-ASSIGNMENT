package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;

public  class DataStore {

  private static HashMap<Integer, Student> studentStorage = new HashMap<Integer, Student>();

  private static HashMap<Integer, Admin> adminStorage = new HashMap<Integer, Admin>();

  public static void fillStudentStorage(String contents) {

      BufferedReader reader = new BufferedReader(new StringReader(contents));

      try {

        String currLine = reader.readLine();

        String [] studentFields = currLine.split(":");
        int id = Integer.parseInt(studentFields[0]);
        String name = studentFields[1];
        String major = studentFields[2];
        double GPA = Double.parseDouble(studentFields[3]);
        String pass = studentFields[4];
        Course [] currCourses = null;
        String [] courseFields = null;

        currLine = reader.readLine();

        studentFields = currLine.split(":");
        for (int i = 0; i < studentFields.length; i++) {
            courseFields = studentFields[i].split(",");

            //currCourses[i] = new Course(courseFields[0], courseFields[1]);
        }

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }

  public static Student findStudent(int iD, String password)
  {
      Student foundStudent = null;

      if(studentStorage.containsKey(iD) == true && studentStorage.get(iD).getPassword().equals(password) == true )
      {
          foundStudent = studentStorage.get(iD);
      }

      return foundStudent;
  }

  public static void addStudentFromAdmin(String major, String password, String name, float gpa, int iD, Course [] curr,
           Course [] past, Fees [] outstanding, Fees [] paid)
  {
      Student new_student = new Student();

      new_student.setName(name);
      new_student.setMajor(major);
      new_student.setGpa(gpa);
      new_student.setPassword(password);
      new_student.setStudentID(iD);
      new_student.setCurrentCourses(curr);
      new_student.setPastCourses(past);
      new_student.setOutstandingFees(outstanding);
      new_student.setPaidFees(paid);


  }

  public static void add_student(Student student_to_be_added)
  {
      studentStorage.put(student_to_be_added.getStudentID(), student_to_be_added);
  }

  public static void remove_student(int student_id, String Name)
  {
      if(studentStorage.containsKey(student_id)== true &&
              studentStorage.get(student_id).getName().equals(Name)== true)
      {
          studentStorage.remove(student_id);
      }
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
