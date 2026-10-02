package com.project.Cafe_Management_System.Service.FeedbackService;

import com.project.Cafe_Management_System.Dto.FeedbackDto.FeedbackDto;
import com.project.Cafe_Management_System.Dto.FeedbackDto.FeedbackResponesDto;

import java.util.List;


public interface FeedbackService {
    public List<FeedbackResponesDto> feedback_Get();
    public FeedbackResponesDto feedback_Post(FeedbackDto feedbackDto);
    public FeedbackResponesDto feedback_Put(Integer id,FeedbackDto feedbackDto);
    public String feedback_Delete(Integer id);
}