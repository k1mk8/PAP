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

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getDzien_dzien_id() {
        return dzien_dzien_id;
    }

    public void setDzien_dzien_id(int dzien_dzien_id) {
        this.dzien_dzien_id = dzien_dzien_id;
    }

    public int getPrzedzialy_przedzial_id() {
        return przedzialy_przedzial_id;
    }

    public void setPrzedzialy_przedzial_id(int przedzialy_przedzial_id) {
        this.przedzialy_przedzial_id = przedzialy_przedzial_id;
    }

    public int getSilownie_id_silowni() {
        return silownie_id_silowni;
    }

    public void setSilownie_id_silowni(int silownie_id_silowni) {
        this.silownie_id_silowni = silownie_id_silowni;
    }
}
