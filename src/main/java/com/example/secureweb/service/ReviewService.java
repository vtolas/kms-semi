package com.example.secureweb.service;

import com.example.secureweb.entity.Review;
import com.example.secureweb.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository repo;

    public Review saveReview(Review r){
        return repo.save(r);
    }

    public List<Review> saveReview(List<Review> lr){
        return repo.saveAll(lr);
    }
    public List<Review> getReviews(){
        return repo.findAll();
    }
    public List<Review> getReviewsByReviewedUser(int id){
        return repo.findByReviewedUserIs(id);
    }
    public Review getReviewById(int id){
        return repo.findById(id).orElse(null);
    }
    public String deleteReview(int id){
        repo.deleteById(id);
        return "removed, id:" + id ;
    }
}
