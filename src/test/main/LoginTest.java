package main;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class LoginTest {

    @Test
    void invalid_login() {
        String contents = ImportConnector.getTextFromURL("File:res\\StudentFile.txt");
        DataStore.fillStudentStorage(contents);

        Login user = new Login();
        assertFalse(user.attemptLogin(1, "x"));
    }

    @Test
    void valid_login() {
        String contents = ImportConnector.getTextFromURL("File:res\\StudentFile.txt");
        DataStore.fillStudentStorage(contents);

        Login user = new Login();
        assert(user.attemptLogin(200000, "KPN"));
    }

}
