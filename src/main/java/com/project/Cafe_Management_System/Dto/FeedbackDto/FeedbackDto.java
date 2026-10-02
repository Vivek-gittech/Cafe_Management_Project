package com.project.Cafe_Management_System.Dto.FeedbackDto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class FeedbackDto {
    @Column(nullable = false)
    private int customer_id;

    @Column(nullable = false)
    private Integer order_id;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private String feedback_text;

    @Column(nullable = false)
    private LocalDateTime created_at;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFeedback_text() {
        return feedback_text;
    }

    public void setFeedback_text(String feedback_text) {
        this.feedback_text = feedback_text;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
