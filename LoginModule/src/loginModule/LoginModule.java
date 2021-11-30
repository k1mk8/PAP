package loginModule;

class InvalidLoginException extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	InvalidLoginException(String message){
        super(message);
    }
        
}

public class LoginModule{
    
    static Boolean logged_in;
    static Boolean nonExistent = false;
    static Boolean isStaff;
    
    /**
     * This method connects with database to retrieve 
     * expected password value for username
     * @param username
     * @return expected password string for comparison
    */
    static String getExpectedPassword(String username){
        
        if (username.equals("user")){
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
    public static void authenticate(String username, String password)  //, haslo
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
