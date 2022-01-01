package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class LoginModule{
	
	public static String message = null;
	private static String connectionUrl = "jdbc:oracle:thin:@//ora4.ii.pw.edu.pl:1521/pdb1.ii.pw.edu.pl";

    /**
     * This method compares provided parameters with expected database value
     * or throws an InvalidLoginException if login is too long or is empty
     * @param username
     * @param password
     */
    public static Boolean authenticate(String login, String password)
    {
    	message = null; 
        String expected_password = null;
		
        try (Connection con = DriverManager.getConnection(connectionUrl,"z24", "ds4znf"); Statement stmt = con.createStatement();) 
        {
            
        	ResultSet rs = stmt.executeQuery("SELECT password FROM temp WHERE login = " + "'" + login + "'");
           
        	if(rs.next()){
        		expected_password = rs.getString("password");
        	}  
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
		
	
        if (password.equals(expected_password)) {
        	
        	message = "Authentication succesful.";
        	return true;
        }
        else {
        	message = "Wrong login or password.";
        	return false;
        }
      
    }
    
  public static Boolean register(String login, String password) {
	  message = null;
	  try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
   
      
      try (Connection con = DriverManager.getConnection(connectionUrl,"z24", "ds4znf"); Statement stmt = con.createStatement();) 
      {
      	
      	ResultSet rs;
      	
      	
      	rs = stmt.executeQuery("SELECT login FROM temp WHERE login = " + "'" + login + "'");
      	
      	if (rs.next()) {
      		message = "Login already taken.";
      		return false;
      		
      	}
      	else {
      	rs = stmt.executeQuery("INSERT INTO temp VALUES (DEFAULT, '" + login + "' , '" + password + "')");
      	rs = stmt.executeQuery("COMMIT");
      	return true;
      	}
      	
          
      }
      // Handle any errors that may have occurred.
      catch (SQLException e) {
          e.printStackTrace();
      }
		return false;
	}
	
	  
	
	  
}	

/**
 * 1.Uruchamia się okno logowania
 * 2. Wpisujemy dane, po drodze sprawdzamy login
 * 3. Sprawdz dane
 * 
*/
