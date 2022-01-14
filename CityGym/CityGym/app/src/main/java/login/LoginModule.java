package login;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class LoginModule{
	
	public static String message = null;
	public static String StoredLogin;
	private static String connectionUrl = "jdbc:oracle:thin:@//ora4.ii.pw.edu.pl:1521/pdb1.ii.pw.edu.pl";
	private static OkHttpClient client = new OkHttpClient();
	//private static final String[] expected_password = {null};




	private static String getPersonFromAPI(String login){

		String[] passwd = {null};
		String JSONresponse = null;

		Request request = new Request.Builder()
				.url("http://192.168.1.17:8080/getperson?login="+ login)
				.build();
		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

			JSONresponse = response.body().string();
			System.out.println("Przed wywolaniem getPasswordFromAPI   " + JSONresponse);

		}
		catch (IOException e){
			e.printStackTrace();
		}

		return JSONresponse;
	}



    /**
     * Compares provided parameters with expected database value
     * @param login
     * @param password
     * @return true if given parameters equal expected values.
     */
    public static Boolean authenticate(String login, String password)
    {
		message = null;
		final String[] expected_password = {null};
		final String[] person = {null};

		if (login.isEmpty()){
			return false;
		}
		else{
			StoredLogin = login;
		}


		Thread loginThread = new Thread(new Runnable() {
			@Override
			public void run() {
				person[0] = getPersonFromAPI(login);
			}
		});

		loginThread.start();

		try {
			loginThread.join();
			JSONObject jsPassword = new JSONObject(person[0]);
			expected_password[0] = jsPassword.getString("password");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch (JSONException j){
			j.printStackTrace();
		}

			System.out.println("Po wywolaniu getPasswordFromAPI " + expected_password[0]);
		if (password.equals(expected_password[0])) {

			message = "Authentication succesful.";
			return true;
		}
		else {
			message = "Wrong login or password.";
			return false;
		}
    }


    public static String getUserData(){
		final String[] person = {null};

		Thread loginThread = new Thread(new Runnable() {
			@Override
			public void run() {
				person[0] = getPersonFromAPI(StoredLogin);
			}
		});

		loginThread.start();

		try {
			loginThread.join();
			JSONObject jsPerson = new JSONObject(person[0]);
			jsPerson.remove("password");
			person[0] = jsPerson.toString();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch (JSONException j){
			j.printStackTrace();
		}
		return person[0];
	}


//	public static Boolean registerUser(String login, String password){
//
//	}

	  
}	

