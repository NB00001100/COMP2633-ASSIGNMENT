package main;

import org.junit.jupiter.api.Test;

class DataStoreTest {

    @Test
    public void test() {

        String test = ImportConnector.getTextFromURL("File:\\C:\\Users\\kusha\\OneDrive\\Documents\\GitHub\\COMP2633-ASSIGNMENT\\res\\AdminFile.txt");


        //DataStore.fillStudentStorage(test);
        DataStore.fillAdminStorage(test);
    }

}
