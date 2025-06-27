package com.example.bai2.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadFeedbackException.class)
    public String handle(BadFeedbackException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}
