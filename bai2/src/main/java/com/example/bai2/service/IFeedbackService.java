package com.example.bai2.service;

import com.example.bai2.model.Feedback;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> findAll();
    Feedback findById(long id);
    void save(Feedback feedback);
    void like(Long id);
}
