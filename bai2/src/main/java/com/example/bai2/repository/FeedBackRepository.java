package com.example.bai2.repository;

import com.example.bai2.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface FeedBackRepository extends JpaRepository<Feedback, Long> {

}
