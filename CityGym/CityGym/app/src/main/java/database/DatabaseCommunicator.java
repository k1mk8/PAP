package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseCommunicator {

	/**
	 * This function creates one time connection
	 * to database and returns password for given login 
	 * (scrollable result of a query) or returns NULL
	 * @param username
	 * @return
	 */
	public static String getPasswd(String username) {
        
		String connectionUrl = "jdbc:oracle:thin:@//ora4.ii.pw.edu.pl:1521/pdb1.ii.pw.edu.pl";
        
        String password = null;
        
        try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     
        
        try (Connection con = DriverManager.getConnection(connectionUrl,"z24", "ds4znf"); Statement stmt = con.createStatement();) 
        {
            
        	ResultSet rs = stmt.executeQuery("SELECT password FROM temp_table WHERE login = " + "'" + username + "'");
           
        	if(rs.next()){
        		password = rs.getString("password");
        	}
            
            
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
		
		return password;
		
    }	
}
	
	
