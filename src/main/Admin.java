package main;

// This class contains all info a admin in the system can have.
public class Admin {

    private int adminID;
    private String adminPassword;

    public Admin(int adminID, String adminPassword) {
        this.adminID = adminID;
        this.adminPassword = adminPassword;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAdminPassword() {
        return adminPassword;
    }


    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }






}
