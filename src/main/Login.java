package main;


// author: Nimrat Brar, Kushal Saini, Pelvain Dhanda

public class Login {

    private boolean userIsAdmin;

    public boolean getUserIsAdmin() {
        return userIsAdmin;
    }

    public void setUserIsAdmin(boolean userIsAdmin) {
        this.userIsAdmin = userIsAdmin;
    }

    // determines if the login information entered was successful by determining if they are in the studentStorage hashmap
    public boolean attemptLogin(int ID, String password)
    {
        boolean id_in_sys = false;
        boolean password_in_sys = false;


        if(ID >= 200000) // student id is greater than 200000
        {

           if(DataStore.getStudentStorage().containsKey(ID) == true) // determines if the 
           {
               id_in_sys = true;

               if(DataStore.getStudentStorage().get(ID).getPassword().equals(password) == true) // determines if password entered and in system match
               {
                   password_in_sys = true;
               }
           }

           if( id_in_sys == true && password_in_sys == true)
           {
               setUserIsAdmin(false);

               return true;
           }
        }
        else if(ID < 200000 && ID >= 100000) // admin id is between 100000 and 200000
        {
            if(DataStore.getAdminStorage().containsKey(ID) == true)
            {
                id_in_sys = true;
                if(DataStore.getAdminStorage().get(ID).getAdminPassword().equals(password)== true) // determines if password entered and in system match
                {
                    password_in_sys = true;
                }
            }

            if( id_in_sys == true && password_in_sys == true)
            {
                setUserIsAdmin(true);

                return true;
            }

        }

        return false;




    }



}
