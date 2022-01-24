package com.loginModule.login;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity


@Table(name = "eventy")
public class Event {

    @Autowired
    @Id
    int event_id;
    String rodzaj;
    String opis;
    int dzien_dzien_id;
    int przedzialy_przedzial_id;
    int silownie_id_silowni;

    public Event(){

    };
    public Event(int event_id, String rodzaj, String opis, int dzien_id, int przedzialy_przedzial_id, int silownie_id_silowni) {
        this.event_id = event_id;
        this.rodzaj = rodzaj;
        this.opis = opis;
        this.dzien_dzien_id = dzien_id;
        this.przedzialy_przedzial_id = przedzialy_przedzial_id;
        this.silownie_id_silowni = silownie_id_silowni;
    }

    public Event( String rodzaj, String opis, int dzien_dzien_id, int przedzialy_przedzial_id, int silownie_id_silowni) {
      
        this.rodzaj = rodzaj;
        this.opis = opis;
        this.dzien_dzien_id = dzien_dzien_id;
        this.przedzialy_przedzial_id = przedzialy_przedzial_id;
        this.silownie_id_silowni = silownie_id_silowni;
    }


    public Event(String rodzaj, String opis, int dzien_dzien_id, int przedzial) {
    }
}
