package com.example.bai2.Controller;

import com.example.bai2.model.Feedback;
import com.example.bai2.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/feedbacks")
public class FeedbackController {
   @Autowired
    private IFeedbackService feedbackService;

    @GetMapping("")
    public String showHomepage(Model model) {
        model.addAttribute("feedbacks", feedbackService.findAll());
        model.addAttribute("newFeedback", new Feedback());
        return "index";
    }

    @PostMapping("/comment")
    public String saveFeedback(@ModelAttribute Feedback newFeedback) {
        feedbackService.save(newFeedback);
        return "redirect:/feedbacks";
    }

    @GetMapping("/like/{id}")
    public String likeFeedback(@PathVariable Long id) {
        feedbackService.like(id);
        return "redirect:/feedbacks";
    }
}
