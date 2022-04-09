package main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DataStoreTest {

    @Test
    public void fill_Hashmap() {

        String contents = ImportConnector.getTextFromURL("File:res\\StudentFile.txt");
        DataStore.fillStudentStorage(contents);

        for (int i = 0; i < 100; i++) {
            assertEquals(i +  200000, DataStore.getStudentStorage().get(200000 + i).getStudentID());
        }
    }

}
