package com.example.secureweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FAHRANGEBOT_TBL")

public class FahrAngebot {
    @Id
    @GeneratedValue
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datum;
    private int ladePlatz;
    private String startOrt;
    private String zielOrt;
    private String status;
    private double weight;
    private double height;
    private double width;
    private double depth;
    private String fahrzeugId;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getStartOrt() {
        return startOrt;
    }

    public void setStartOrt(String startOrt) {
        this.startOrt = startOrt;
    }

    public String getZielOrt() {
        return zielOrt;
    }

    public void setZielOrt(String zielOrt) {
        this.zielOrt = zielOrt;
    }

    public String getUser() {
        return this.user;
    }

    private String user;
}
