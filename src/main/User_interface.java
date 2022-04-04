import  java.util.HashMap;

public  class DataStore {

  private static HashMap<Integer, Student> studentStorage = new HashMap<Integer, Student>();

    private static HashMap<Integer, Admin> adminStorage = new HashMap<Integer, Admin>();

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
