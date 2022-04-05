package main;

import org.junit.jupiter.api.Test;

class DataStoreTest {

    @Test
    public void test() {

        String test = "200000:first last0:ComputerScience:2.0:KPN\n"
                + "courseName1,1:courseName2,2:courseName3,3:\n"
                + "courseName2,2:courseName3,3:courseName3,3:\n"
                + "feeName3,3:feeName2,2:feeName0,0:\n"
                + "feeName1,1:feeName3,3:feeName1,1:\n";


        DataStore.fillStudentStorage(test);

    }

}
