package com.example.secureweb.repository;

import com.example.secureweb.entity.FahrAngebot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface FahrAngebotRepository extends JpaRepository<FahrAngebot, Integer> {
    public List<FahrAngebot> findByStartOrtIsLikeAndZielOrtIsLikeAndDatumAfter(String startOrt, String zielOrt, Date datum);
}
