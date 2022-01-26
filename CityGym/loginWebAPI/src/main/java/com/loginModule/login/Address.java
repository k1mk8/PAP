package com.loginModule.login;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adresy")
public class Address {

    @Autowired

    @Id
    private int adres_id;
    private String kraj;
    private String miasto;
    private String kod_pocztowy;
    private String ulica;
    private String nr_budynku;
    private String nr_mieszkania;
    private int regiony_id_regionu;


    public Address(){};

    public Address(int adres_id, String kraj, String miasto, String kod_pocztowy, String ulica, String nr_budynku, String nr_mieszkania, int regiony_id_regionu) {
        this.adres_id = adres_id;
        this.kraj = kraj;
        this.miasto = miasto;
        this.kod_pocztowy = kod_pocztowy;
        this.ulica = ulica;
        this.nr_budynku = nr_budynku;
        this.nr_mieszkania = nr_mieszkania;
        this.regiony_id_regionu = regiony_id_regionu;
    }



    public Address( String kraj, String miasto, String kod_pocztowy, String ulica, String nr_budynku, String nr_mieszkania, int regiony_id_regionu) {

        this.kraj = kraj;
        this.miasto = miasto;
        this.kod_pocztowy = kod_pocztowy;
        this.ulica = ulica;
        this.nr_budynku = nr_budynku;
        this.nr_mieszkania = nr_mieszkania;
        this.regiony_id_regionu = regiony_id_regionu;
    }
    public int getAdres_id() {
        return adres_id;
    }

    public void setAdres_id(int adres_id) {
        this.adres_id = adres_id;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNr_budynku() {
        return nr_budynku;
    }

    public void setNr_budynku(String nr_budynku) {
        this.nr_budynku = nr_budynku;
    }

    public String getNr_mieszkania() {
        return nr_mieszkania;
    }

    public void setNr_mieszkania(String nr_mieszkania) {
        this.nr_mieszkania = nr_mieszkania;
    }

    public int getRegiony_id_regionu() {
        return regiony_id_regionu;
    }

    public void setRegiony_id_regionu(int regiony_id_regionu) {
        this.regiony_id_regionu = regiony_id_regionu;
    }
}
