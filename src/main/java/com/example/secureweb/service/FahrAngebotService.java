package com.example.secureweb.service;

import com.example.secureweb.entity.FahrAngebot;
import com.example.secureweb.repository.FahrAngebotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FahrAngebotService {
    @Autowired
    private FahrAngebotRepository repo;

    public FahrAngebot saveFahrAngebot(FahrAngebot fa){
       return repo.save(fa);
    }

    public List<FahrAngebot> saveFahrAngebote(List<FahrAngebot> lfa){
        return repo.saveAll(lfa);
    }
    public List<FahrAngebot> getFahrAngebote(){
        return repo.findAll();
    }
    public FahrAngebot getFahrAngebotById(int id){
        return repo.findById(id).orElse(null);
    }
    public String deleteFahrAngebot(int id){
        repo.deleteById(id);
        return "removed, id:" + id ;
    }
    public List<FahrAngebot> findResults(String startOrt, String zielOrt, Date datum){
        return repo.findByStartOrtIsLikeAndZielOrtIsLikeAndDatumAfter(startOrt,  zielOrt,  datum);
    }
}
