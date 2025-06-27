package com.example.bai2.logger;

import com.example.bai2.exception.BadFeedbackException;
import com.example.bai2.model.Feedback;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Aspect
@Component
public class FeedbackLogger {
    private static  Logger log = LoggerFactory.getLogger(FeedbackLogger.class);

    @AfterThrowing(pointcut = "execution(* com.example.bai2.Controller.FeedbackController.saveFeedback(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint , BadFeedbackException ex) {
        System.err.println("🔴 PHÁT HIỆN BÌNH LUẬN VI PHẠM 🔴");

        // Đây là thời gian thực tế
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Vì Exception không chứa comment nên chỉ log message chung
        System.err.println("⏰ Thời gian: " + timestamp);
        System.err.println("⚠️ Lỗi: " + ex.getMessage());
    }
}
