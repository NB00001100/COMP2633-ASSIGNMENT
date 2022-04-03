// author: Nimrat Brar, add names

public class Login {

    private boolean userIsAdmin;

    public boolean getUserIsAdmin() {
        return userIsAdmin;
    }

    public void setUserIsAdmin(boolean userIsAdmin) {
        this.userIsAdmin = userIsAdmin;
    }

    public boolean attemptLogin(int ID, String password)
    {
        boolean id_in_sys = false;
        boolean password_in_sys = false;
        DataStore check = null;

        if(ID > 200000) // student id is greater than 200000
        {

           if(check.studentStorage.containsKey(ID) == true)
           {
               id_in_sys = true;

           }
           if(check.studentStorage.containsValue(check.studentStorage.get(ID).getPassword().compareTo(password)) == true) // might have errors
           {
               password_in_sys = true;
           }
           if( id_in_sys == true && password_in_sys == true)
           {
               setUserIsAdmin(false);

               return true;
           }
        }
        else if(ID < 200000 && ID > 100000) // admin id is between 100000 and 200000
        {
            if(check.adminStorage.containsKey(ID) == true)
            {
                id_in_sys = true;

            }
            if(check.adminStorage.containsValue(check.adminStorage.get(ID).getAdminPassword().compareTo(password)) == true) // might have errors
            {
                password_in_sys = true;
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
