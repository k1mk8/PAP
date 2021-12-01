package login;

class InvalidLoginException extends Exception{

    InvalidLoginException(String message){
        super(message);
    }
        
}

public class LoginModule{
    
    static Boolean logged_in;
    static Boolean isTrainer;
    static Boolean nonExistent = false;
    /**
     * This method connects with database to retrieve 
     * expected password value for username
     * @param username
     * @return expected password string for comparison
    */
    static String getExpectedPassword(String username){
        
        if (username.equals("user")){
            isTrainer = false;
            return "password";
        }
        if (username.equals("trainer")){
            isTrainer = true;
            return "password";
        }
        return "wrong_password";
    }

    static Boolean userInDatabase(String username){
        if (username.equals("user")){return true;}
        
        return false;
    }

    /**
     * This method compares provided parameters with expected databaseee value
     * or throws an InvalidLoginException if login is too long or is empty
     * @param username
     * @param password
     */
    public static int authenticate(String username, String password)
    {
        // //Check validity of username
        try{
            if (username.isEmpty()){throw new InvalidLoginException("Username cannot be empty\n");}
            if (username.length() > 8) {throw new InvalidLoginException("Username cannot exceed 8 characters\n");}
            if (userInDatabase(username) && nonExistent ){throw new InvalidLoginException("Provided login does not exist.\n");}

            //if input ok, proceed to authentication
            String expected_password = getExpectedPassword(username);

            // Checking the validity of the password
            if(password.equals(expected_password))
            {
                // Printing Output
                System.out.println("Authentication Successful");
                logged_in = true;
                return isTrainer ? 2 : 1;
            }
            else
            {
                // Printing Output
                System.out.println("User name/ Password not matching");
            }

        }
        catch( InvalidLoginException ILE){
            System.out.print(ILE.getMessage());
        }
        return 0;
    }


    /**
     * this method sets loggedIn flag to false 
     */
    public static void logOut(){
        logged_in = false;
    }
   
}



/**
 * 1.Uruchamia się okno logowania
 * 2. Wpisujemy dane, po drodze sprawdzamy login
 * 3. Sprawdz dane
 * 
*/
