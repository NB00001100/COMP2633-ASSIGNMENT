package main;

// This class contains all the info a course can have.
public class Course {

    private String courseName;

    private int courseID;



    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }


    public Course(String courseName, int courseID) {
        super();
        this.courseName = courseName;
        this.courseID = courseID;
    }


    public String getCourseName() {
        return courseName;
    }


    public int getCourseID() {
        return courseID;
    }





}
