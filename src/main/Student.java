package main;
/*
This class holds all the values a student can have
*/

public class Student {

    private double gpa;
    private String name;
    private String major;
    private int studentID;
    private String studentPassword;
    private Fees[] outstandingFees = new Fees[50];
    private Fees[] paidFees = new Fees[50];
    private Course[] currentCourses = new Course[5]; 
                                                     
    private Course[] pastCourses = new Course[40]; 
                                                   
                                                   


    public Student(double gpa, String name, String major, int studentID, String studentPassword, Fees[] textOutstandingFees,
            Fees[] textPaidFees, Course[] textCurrCourse, Course[] textPastCourse) {
        super();
        this.gpa = gpa;
        this.name = name;
        this.major = major;
        this.studentID = studentID;
        this.studentPassword = studentPassword;
        intializeArrays();

        for(int i = 0; i< textCurrCourse.length; i++)
        {

            currentCourses[i] = textCurrCourse[i];

        }

        for(int i = 0; i< textPastCourse.length; i++)
        {

            pastCourses[i] = textPastCourse[i];

        }


        for(int i = 0; i< textPaidFees.length; i++)
        {

            paidFees[i] = textPaidFees[i];

        }


        for(int i = 0; i< textOutstandingFees.length; i++)
        {

            outstandingFees[i] = textOutstandingFees[i];

        }




    }





  public Student() {



     }





    // This method intializes all the elements of the student class to null because show_fees and show_courses rely on that
    public void intializeArrays() {
        int outStandingFeesCounter = 0;
        int feesPaidCounter = 0;
        int currentCoursesCounter = 0;
        int pastCoursesCounter = 0;

        while (outStandingFeesCounter < getOutstandingFees().length) {
            this.outstandingFees[outStandingFeesCounter] = null;

            outStandingFeesCounter++;

        }

        while (feesPaidCounter < getPaidFees().length) {
            this.paidFees[feesPaidCounter] = null;
            feesPaidCounter++;

        }

        while (currentCoursesCounter < getCurrentCourses().length) {
            this.currentCourses[currentCoursesCounter] = null;

            currentCoursesCounter++;

        }

        while (pastCoursesCounter < getPastCourses().length) {
            this.pastCourses[pastCoursesCounter] = null;

            pastCoursesCounter++;

        }

    }


    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;

    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getPassword() {
        return studentPassword;
    }

    public void setPassword(String password) {
        this.studentPassword = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course[] getCurrentCourses() {
        return currentCourses;
    }

    public void setCurrentCourses(Course[] currentCourses) {
        this.currentCourses = currentCourses;
    }

    public Course[] getPastCourses() {
        return pastCourses;
    }

    public void setPastCourses(Course[] pastCourses) {
        this.pastCourses = pastCourses;
    }

    public Fees[] getOutstandingFees() {
        return outstandingFees;
    }

    public void setOutstandingFees(Fees[] outstandingFees) {
        this.outstandingFees = outstandingFees;
    }

    public Fees[] getPaidFees() {
        return paidFees;
    }

    public void setPaidFees(Fees[] paidFees) {
        this.paidFees = paidFees;
    }

}
