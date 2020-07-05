package com.example.FahrerAbwicklung;

import java.util.HashMap;
import java.util.List;

public class UserHandler {

    static private List<User> userList;
    static private HashMap<User, String> LogInData;
    //static private HashMap<Fahrer,List<Bewertung>> bewertungen;


    public static final String userRegex = "([a-z]|[A-Z]|[0-9]){5,12}";
    public static final String passRegex =  "^(?=.{8,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])";


    static boolean createUser(String userName,String passwort) {
        if (userList.contains(userName)) {
            System.out.println("Username alrady Taken");
            return false;
        }

        if (!userName.matches(userRegex)) {
            System.out.println("Username darf nur Buchstaben oder Zahlen enthalten und muss 5-12 Zeichen beinhalten");
            return false;
        }
        if (!passwort.matches(passRegex)) {
            System.out.println("Passwort muss mindestens 1 Großbuchstaben 1 kleinbuchstaben 1ne Zahl und mindestens 8 zeichen lang sein");
            return false;
        }

        return true;
    }




}

class Bewertungen {

    String text;
    int sternanzahl;


    public Bewertungen(String text, int sternanzahl) {
        this.text = text;
        this.sternanzahl = sternanzahl;
    }
}
