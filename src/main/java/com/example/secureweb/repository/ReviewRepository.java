package com.example.secureweb.repository;

import com.example.secureweb.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    public List<Review> findByReviewedUserIs(int id);
}
