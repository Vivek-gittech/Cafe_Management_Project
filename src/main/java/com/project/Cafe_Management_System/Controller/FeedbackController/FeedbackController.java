package com.project.Cafe_Management_System.Controller.FeedbackController;

import com.project.Cafe_Management_System.Dto.FeedbackDto.FeedbackDto;
import com.project.Cafe_Management_System.Dto.FeedbackDto.FeedbackResponesDto;
import com.project.Cafe_Management_System.Service.FeedbackService.FeedbackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/Get")
    public List<FeedbackResponesDto> feedback_Get(){
        return feedbackService.feedback_Get();
    }
    @PostMapping("/Post")
    public FeedbackResponesDto feedback_Insert(@RequestBody FeedbackDto feedbackDto){
        return feedbackService.feedback_Post(feedbackDto);
    }
    @PutMapping("/Update/{id}")
    public FeedbackResponesDto feedback_Update(@PathVariable Integer id,@RequestBody FeedbackDto feedbackDto){
        return feedbackService.feedback_Put(id,feedbackDto);
    }
    @DeleteMapping("/Delete/{id}")
    public String feedback_Delete(@PathVariable Integer id){
        return feedbackService.feedback_Delete(id);
    }
}
