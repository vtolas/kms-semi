package com.example.secureweb.repository;

import com.example.secureweb.entity.FahrAngebot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FahrAngebotRepository extends JpaRepository<FahrAngebot, Integer> {
    public List<FahrAngebot> findByDatumAfterAndZielOrtAndStartOrt(Date datum, String zielOrt, String startOrt);
}
