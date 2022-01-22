package com.loginModule.login;

import net.bytebuddy.build.RepeatedAnnotationPlugin;
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
	public Boolean register(@RequestParam   String imie,
							 String nazwisko, String PESEL, String data_urodzenia,
							 String login, String haslo){

		List<Person> list = repo.findByLogin(login);
		System.out.println("LIST OF USERS WITH THAT LOGIN	" + list);

		if (list.isEmpty()){
			Person newPerson = new Person(100,"Klient",  imie,
					nazwisko,  PESEL,  data_urodzenia, data_urodzenia, login,  haslo,6);
			repo.save(newPerson);

			return true;
		}
		else{
			return false;
		}
	}






	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

}




//	@("/checkIfExists")
//	public Boolean checkIfExists(@RequestParam String login){
//		List<Person> list = repo.findByLogin(login);
//		System.out.println(list);
//		if (list.isEmpty()){
//			return false; //does not exist
//		}
//		else{
//			return true; //provided login is taken
//		}
//	}
//
//	@PostMapping ("/insertAllData")
//	public Boolean insertAllData(@RequestParam String login, String password, .............){
//		Person newPerson = new Person();
//		newPerson.setPassword(password);
//		newPerson.setLogin(login);
//		Person person = repo.save(newPerson);
//		if(person.isEmpty){
//			return false;
//		}
//		return true;
//
//	}
