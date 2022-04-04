import  java.util.HashMap;

public  class DataStore {

  private static HashMap<Integer, Student> studentStorage = new HashMap<Integer, Student>();

  private static HashMap<Integer, Admin> adminStorage = new HashMap<Integer, Admin>();




  public static Student findStudent(int iD, String password)
  {
      Student foundStudent = null;

      if(studentStorage.containsKey(iD) == true && studentStorage.get(iD).getPassword().equals(password) == true )
      {
          foundStudent = studentStorage.get(iD);
      }

      return foundStudent;
  }

  public static void addStudentFromAdmin(String major, String password, float gpa, int iD, Course [] curr,
           Course [] past, Fees [] outstanding, Fees [] paid)
  {


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
