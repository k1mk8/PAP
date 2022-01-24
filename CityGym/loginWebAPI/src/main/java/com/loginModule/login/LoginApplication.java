package com.loginModule.login;

import net.bytebuddy.build.RepeatedAnnotationPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.interceptor.AroundInvoke;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.lang.reflect.Array;
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

//	@GetMapping("/getpassword")
//	public String getPassword(@RequestParam String login){
//
//		List<Person> list = repo.findByLogin(login);
//		Person person = list.get(0);
//		String password = list.get(0).getLogin().toString();
//		System.out.println(password);
//
//		return password;
//	}

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
							//15 params

		System.out.println("TAKI JEST PODANY KURWIONY LOGIN:    " + login);
		String received_login = repo.findByLogin_v2(login);
		System.out.println("LIST OF USERS WITH THAT LOGIN	" + received_login);

		if (received_login == null) {
//			System.out.println("WEWNATRZ PIERDOLONEGO IF     " + list);
////			Address newAddress = new Address( kraj,  miasto,  kod_pocztowy,  ulica,  nr_budynku,  nr_mieszkania, 1);
////			addressRepo.save(newAddress);
////
////			int address_id = addressRepo.findAddressId(kraj,  miasto,  kod_pocztowy,  ulica,  nr_budynku,  nr_mieszkania, 1);
//
				try {
					repo.create_adres_and_czlonek(kraj, miasto, kod_pocztowy, ulica,
							nr_budynku, nr_mieszkania, region, "Klient", imie,
							nazwisko, PESEL, data_urodzenia,
							login, haslo, email);
				}
				catch(NegativeArraySizeException n){

				}

			System.out.println("Po wywolaniusdahksuhbluhsvbklu;j.HKAuwj.skhvjnsbjk.hv");

			return true;
		}
		else{return false;}

	}









	@PostMapping("/addEvent")
	public Boolean addEvent(@RequestParam String rodzaj, String opis, int dzien_dzien_id, int przedzialy_przedzial_id){


			Event event = new Event(rodzaj, opis, dzien_dzien_id, przedzialy_przedzial_id);
			EventRepo.save(event);
			return true;

	}



	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

}


