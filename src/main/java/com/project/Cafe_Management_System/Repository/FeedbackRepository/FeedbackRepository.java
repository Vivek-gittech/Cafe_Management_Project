package com.project.Cafe_Management_System.Repository.FeedbackRepository;

import com.project.Cafe_Management_System.Entity.FeedbackEntity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
}
