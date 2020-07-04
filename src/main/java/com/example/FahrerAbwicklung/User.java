package com.example.FahrerAbwicklung;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    String  username;
    private String passwort;


    String  vorname;
    String nachname;
    Date geburtsdatum;
    String straße;
    int hausnummer;
    String Stadt;
    int plz;
    String telefon;


    public User(String username,String passwort,String vorname, String nachname, Date geburtsdatum, String straße, int hausnummer, String stadt, int plz, String telefon) {
        this.username = username;
        this.passwort = passwort;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.straße = straße;
        this.hausnummer = hausnummer;
        Stadt = stadt;
        this.plz = plz;
        this.telefon = telefon;
    }




}


class Fahrer extends User {

    Fahrzeug fahrzeug;


    public Fahrer(String username, String passwort, String vorname, String nachname, Date geburtsdatum, String straße, int hausnummer, String stadt, int plz, String telefon,Fahrzeug fahrzeug) {
        super(username, passwort, vorname, nachname, geburtsdatum, straße, hausnummer, stadt, plz, telefon);
        this.fahrzeug = fahrzeug;
    }




}


class Nutzer extends User {

    public Nutzer(String username, String passwort, String vorname, String nachname, Date geburtsdatum, String straße, int hausnummer, String stadt, int plz, String telefon) {
        super(username, passwort, vorname, nachname, geburtsdatum, straße, hausnummer, stadt, plz, telefon);
    }

}