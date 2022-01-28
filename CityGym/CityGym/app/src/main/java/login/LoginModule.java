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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class LoginModule{

	public static String message = null;
	public static String StoredLogin;
	private static String connectionUrl = "jdbc:oracle:thin:@//ora4.ii.pw.edu.pl:1521/pdb1.ii.pw.edu.pl";
	private static OkHttpClient client = new OkHttpClient();
	private static String API_Address = "192.168.0.192";
	//private static final String[] expected_password = {null};


	/**
	 *
	 * @param login
	 * @return
	 */

	private static String getPersonFromAPI(String login){

		String[] passwd = {null};
		String JSONresponse = null;

		Request request = new Request.Builder()
				.url("http://"+API_Address+":8080/getperson?login="+ login)
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
	 *
	 * @param imie
	 * @param nazwisko
	 * @param PESEL
	 * @param data_urodzenia

	 * @param login
	 * @param haslo
	 * @return
	 */
	 public static Boolean register(String kraj, String miasto, String kod_pocztowy, String ulica,
									String nr_budynku, String nr_mieszkania,int region,String imie,
									String nazwisko, int PESEL, String data_urodzenia,
									String login, String haslo, String email){

		 final Boolean[] registration_result = {false};


		 Thread loginThread = new Thread(new Runnable() {
			 @Override


			 public void run() {

				 MediaType mediaType = MediaType.parse("text/plain");
				 RequestBody body = RequestBody.create(mediaType, "");



				 Request request = new Request.Builder()
						 .url("http://"+API_Address+":8080/register?kraj="+kraj+"&miasto="+miasto+"&kod_pocztowy="+kod_pocztowy+"&ulica="+ulica+
								 "&nr_budynku="+nr_budynku+"&nr_mieszkania="+nr_mieszkania+"&region="+region+"&imie="+imie+"&nazwisko="+nazwisko+"&PESEL="+PESEL+
								 "&data_urodzenia="+data_urodzenia+"&login="+login+"&haslo="+haslo+"&email="+email)
						 .method("POST", body)
						 .build();


				 try (Response response = client.newCall(request).execute()) {
					 if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

					 System.out.println("WEWNATRZ REJESTRACJI");
					 registration_result[0] = Boolean.parseBoolean(response.body().string());
				 }
				 catch (IOException e){
					 e.printStackTrace();
				 }
			 }
		 });

		 loginThread.start();

		 try {
			 loginThread.join();
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 }

		 return registration_result[0];


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
		 String[] person = {null};

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
				System.out.println(person[0]);
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

	public static Boolean getTrainer(){
    	String data = getUserData();

		JSONObject jsData = null;
		try {
			jsData = new JSONObject(data);
			if(jsData.getString("trener_flag").equals("Trener")){
				return true;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}


    	return false;
	}

    public static String getUserData(){
		String[] person = {null};

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


	public static String getEventByID(int event_id){

		final String[] event = {null};


		Thread loginThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Request request = new Request.Builder()
						.url("http://"+API_Address+":8080/getEventByID?event_id="+ event_id)
						.build();
				try (Response response = client.newCall(request).execute()) {
					if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

					event[0] = response.body().string();

				}
				catch (IOException e){
					e.printStackTrace();
				}
			}
		});

		loginThread.start();

		try {
			loginThread.join();
			JSONObject jsEvent = new JSONObject(event[0]);
			event[0] = jsEvent.toString();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch (JSONException j){
			j.printStackTrace();
		}



		return event[0];


	}


	public static String getEventByDesc(String opis){

		final String[] event = {null};


		Thread loginThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Request request = new Request.Builder()
						.url("http://"+API_Address+":8080/getEventByDesc?opis="+ opis)
						.build();
				try (Response response = client.newCall(request).execute()) {
					if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

					event[0] = response.body().string();

				}
				catch (IOException e){
					e.printStackTrace();
				}
			}
		});

		loginThread.start();

		try {
			loginThread.join();
			JSONObject jsEvent = new JSONObject(event[0]);
			event[0] = jsEvent.toString();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch (JSONException j){
			j.printStackTrace();
		}



		return event[0];


	}

	public static Boolean changePassword(String login, String old_pass, String new_pass) {

		final Boolean[] result = {false};
		if (authenticate(login, old_pass)) {
			System.out.println(login);
			System.out.println(old_pass);
			System.out.println(new_pass);
			Thread loginThread = new Thread(new Runnable() {
				@Override
				public void run() {
					Request request = new Request.Builder()
							.url("http://" + API_Address + ":8080/changePassword?login=" + login +
									"&haslo=" + new_pass)
							.build();
					try (Response response = client.newCall(request).execute()) {
						System.out.println(response.body().string());
						if (!response.isSuccessful())
							throw new IOException("Unexpected code " + response);

						result[0] = Boolean.parseBoolean(response.body().string());

						System.out.println(result[0]);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});

			loginThread.start();

			try {
				loginThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		return result[0];
	}

}	

