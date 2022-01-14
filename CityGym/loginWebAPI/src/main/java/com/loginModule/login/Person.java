package com.loginModule.login;


import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;

@Entity


@Table(name = "czlonkowie")
public class Person {
    @Id
    private int czlonek_id;

    private String trener_flag;
    private String imie;
    private String nazwisko;
    private String PESEL;
    private String data_urodzenia;
    private String data_dolaczenia;
    private String login;
    private String haslo;
    private int adresy_adres_id;

    public static Person nullPerson(){
        return new Person(0, null, null, null,null,null, null, null, null,0);
    }
    public Person() {}

//    public Person(int id, String trener_flag, String name, String surname,
//                  String PESEL, String date_join, String date_leave, String login,
//                  String password, String email, int address_id) {
//        this.id = id;
//        this.trener_flag = trener_flag;
//        this.name = name;
//        this.surname = surname;
//        this.PESEL = PESEL;
//        this.date_birth = date_birth;
//        this.date_join = date_join;
//        this.login = login;
//        this.password = password;
//        this.email = email;
//        this.address_id = address_id;
//    }

    public Person(int czlonek_id, String trener_flag, String imie, String nazwisko,
                  String PESEL, String data_urodzenia, String data_dolaczenia, String login,
                  String haslo, int adresy_adres_id) {
        this.czlonek_id = czlonek_id;
        this.trener_flag = trener_flag;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.data_urodzenia = data_urodzenia;
        this.data_dolaczenia = data_dolaczenia;
        this.login = login;
        this.haslo = haslo;
        this.adresy_adres_id = adresy_adres_id;
    }

    public int getId() {
        return czlonek_id;
    }

    public void setId(int id) {
        this.czlonek_id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return haslo;
    }

    public String getName() {
        return imie;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public void setPassword(String password){
        this.haslo = password;
    }
}