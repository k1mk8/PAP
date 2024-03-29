package com.loginModule.login;

import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@SpringBootApplication
public class LoginApplication {
	@Autowired
	UserRepository repo;
	@Autowired
	AddressRepository addressRepo;
	@Autowired
	EventRepository EventRepo;


	@GetMapping("/getperson")
	public Person getPerson(@RequestParam String login){
		List<Person> list = repo.findByLogin(login);
		if (list.isEmpty()){
			return Person.nullPerson();
		}
		Person person = list.get(0);

		return person;
	}


	@PostMapping("/register")
	public Boolean register(@RequestParam  String kraj, String miasto, String kod_pocztowy, String ulica,
							String nr_budynku, String nr_mieszkania,int region,String imie,
							 String nazwisko, int PESEL, String data_urodzenia,
							 String login, String haslo, String email){
							//14 params

		System.out.println("TAKI JEST PODANY  LOGIN:    " + login);
		String received_login = repo.findByLogin_v2(login);
		System.out.println("LIST OF USERS WITH THAT LOGIN	" + received_login);

		if (received_login == null) {

				try {
					repo.create_adres_and_czlonek(kraj, miasto, kod_pocztowy, ulica,
							nr_budynku, nr_mieszkania, region, "Klient", imie,
							nazwisko, PESEL, data_urodzenia,
							login, haslo, email);
				}
				catch(NegativeArraySizeException n){

				}



			return true;
		}
		else{return false;}

	}








	@GetMapping("/getEventByID")
	public Event getEventByID(@RequestParam int event_id){

		List <Event> eventList = EventRepo.getEventByID(event_id);

		Event event = eventList.get(0);
		return event;

	}

	@GetMapping("/getEventByDesc")
	public Event getEventByDesc(@RequestParam String opis){

		List <Event> eventList = EventRepo.getEventByDesc(opis);

		Event event = eventList.get(0);
		return event;

	}



	@PostMapping("/addEvent")
	public void addEvent(@RequestParam String rodzaj, String opis, int dzien_dzien_id, int przedzialy_przedzial_id, int silownie_id_silowni){

		try {
			EventRepo.addEvent(rodzaj, opis, dzien_dzien_id, przedzialy_przedzial_id, silownie_id_silowni);
		}
		catch(NegativeArraySizeException n){
			}



	}


	@PostMapping("/changePassword")
	public Boolean changePassword(@RequestParam String login, String haslo){
		try {
			repo.update_password(login, haslo);
		}
		catch(NegativeArraySizeException n){
		}

		Person person = getPerson(login);
		if(person.getPassword().equals(haslo)){
			return true;
		}
		return true;
	}

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}


}

