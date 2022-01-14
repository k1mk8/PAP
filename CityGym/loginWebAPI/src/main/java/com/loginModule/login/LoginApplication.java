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
		System.out.println(list);
		if (list.isEmpty()){
			return Person.nullPerson();
		}
		Person person = list.get(0);

		return person;
	}
	@PutMapping("/register")
	public Boolean registerLogin(@RequestParam String login, String password){
		List<Person> list = repo.findByLogin(login);
		System.out.println(list);
		if (list.isEmpty()){
			return false;
		}
		else{


			Person newPerson = new Person();
			newPerson.setPassword(password);
			newPerson.setLogin(login);
			repo.save(newPerson);
			return true;
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

}
