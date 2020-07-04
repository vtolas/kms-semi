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
    private double price;

    public void setUser(String user) {
        this.user = user;
    }

    private String user;
}
