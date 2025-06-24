package com.example.bai2.service;

import com.example.bai2.model.Feedback;
import com.example.bai2.repository.FeedBackRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private FeedBackRepository feedBackRepository;

    @Override
    public List<Feedback> findAll() {
        return feedBackRepository.findAll();
    }


    @Override
    public Feedback findById(long id) {
     return feedBackRepository.findById(id).get();
    }

    @Override
    public void save(Feedback feedback) {
       feedBackRepository.save(feedback);
    }

    @Override
    public void like(Long id) {
    Feedback feedback = findById(id);
    if (feedback != null) {
        feedback.setLikes(feedback.getLikes() + 1);
        feedBackRepository.save(feedback);
    }
    }
}
