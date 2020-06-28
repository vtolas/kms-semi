package com.example.FahrerAbwicklung;

import java.sql.Time;
import java.util.List;

public class Fahrzeug {

    private final int carId;
    private final Size3Dem stauPlatz;
    private final String FahrZeugname;
    private final int beiFahrerSitze;
    private CarStatus carStatus;

    List<Packet> pakete;




    public Fahrzeug(Fahrer fahrer,String name, int carId, Size3Dem sD,  int beiFahrerSitze) {
        this.FahrZeugname = name;
        this.carId = carId;
        this.stauPlatz = sD;
        this.beiFahrerSitze = beiFahrerSitze;
    }





    public String toString() {

        return "Fahrzeug mit dem name " + this.FahrZeugname + "mit der ID " + carId + "verfügt über " + this.beiFahrerSitze + "und einen stauplatz von " + stauPlatz.toString() +
                "\n " + carStatus.toString();

    }



}

class CarStatus {

    private String zielOrt;
    String zustand; // "waiting", "planed", "onTrack" , "delivert"
    String stadt;

    Time startTime, diliverTime;


    private CarStatus(String zustand, String start) {
        this.zustand = zustand;
        this.stadt = stadt;
    }

    private CarStatus(String zustand, String start, String ziel, Time startTime, Time diliverTime) {
        this.stadt = start;
        this.zielOrt = ziel;
        this.startTime = startTime;
        this.diliverTime = diliverTime;
        this.zustand = zustand;

    }


    public static CarStatus waiting(String stadt) {
        CarStatus res = new CarStatus("waiting", stadt);
        return res;
    }

    public static CarStatus createDrive(String start, String ziel, Time startTime, Time diliverTime) {
        CarStatus res = new CarStatus("planed", start, ziel, startTime, diliverTime);
        return res;
    }

    public void OnTrack() {
        this.zustand = "onTrack";
    }

    public void delivert() {
        this.zustand = "delivert";
    }


    @Override
    public String toString() {
       
        switch (this.zustand) {
            case "waiting"  : return "Das Fahrzeug steht unbenutzt in " + stadt + "und wartet auf einen Auftrag";
            case "delivert" : return "Das Fahrzeug hat gerade seinen Pakete in der Stadt " + stadt + " erfolgreich  um " + diliverTime + "abgegeben";
            case "onTrack"  : return "Das Fahrzeug befindet sich auf dem Weg von  " + stadt + "nach " + zielOrt + " un wird dort vorraussichtlich um " + diliverTime + "ankommen";
            case "planed"   : return "Das Fahrzeug wird um " + startTime +  "nach " + zielOrt + "fahren";
            default : return "Der Zustand des Fahrzeugs unbekannt";
        }
        
        
        
        
    }

}


class Size3Dem {

    int x;
    int y;
    int z;

    public Size3Dem(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
   public String toString() {

        return String.format("%d Meter Höhe %d Meter Breite und  %d Meter länge");

    }

}


class Packet {

    Size3Dem size;
    int ID;
    double gewichtKilo;





}
