package com.project.Cafe_Management_System.Service.FeedbackService.FeedbackServiceIml;

import com.project.Cafe_Management_System.Dto.FeedbackDto.FeedbackDto;
import com.project.Cafe_Management_System.Dto.FeedbackDto.FeedbackResponesDto;
import com.project.Cafe_Management_System.Entity.CustomerEntity.Customer;
import com.project.Cafe_Management_System.Entity.FeedbackEntity.Feedback;
import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import com.project.Cafe_Management_System.Mapper.FeedbackMapper.FeedbackMapper;
import com.project.Cafe_Management_System.Repository.CustomerRepository.CustomerRepository;
import com.project.Cafe_Management_System.Repository.FeedbackRepository.FeedbackRepository;
import com.project.Cafe_Management_System.Repository.OrderRepository.OrderRepository;
import com.project.Cafe_Management_System.Service.FeedbackService.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceIml implements FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public FeedbackServiceIml(FeedbackRepository feedbackRepository, FeedbackMapper feedbackMapper, CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.feedbackRepository = feedbackRepository;
        this.feedbackMapper = feedbackMapper;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<FeedbackResponesDto> feedback_Get(){
        List<Feedback> feedback=feedbackRepository.findAll();
        return FeedbackMapper.feedback_Get(feedback);
    }
    public FeedbackResponesDto feedback_Post(FeedbackDto feedbackDto){
        Customer customer=customerRepository.findById(feedbackDto.getCustomer_id()).orElseThrow(()->new RuntimeException("Customer Not Found"));
        Feedback feedback=FeedbackMapper.to_Entity(feedbackDto,customer);
        System.out.println("Customer_id"+feedbackDto.getCustomer_id());
        Feedback feedbackSaved=feedbackRepository.save(feedback);
        return FeedbackMapper.to_Dto(feedbackSaved);
    }
    public FeedbackResponesDto feedback_Put(Integer id,FeedbackDto feedbackDto){
        Feedback feedback=feedbackRepository.findById(id).orElseThrow(()->new RuntimeException("Feedback not Found"));
        Order order=orderRepository.findById(feedbackDto.getOrder_id()).orElseThrow(()->new RuntimeException("Order Not Found"));
        FeedbackMapper.feedback_put(feedback,feedbackDto,order);
        Feedback feedbackSaved=feedbackRepository.save(feedback);
        return FeedbackMapper.to_Dto(feedbackSaved);
    }
    public String feedback_Delete(Integer id){
        Feedback feedback=feedbackRepository.findById(id).orElseThrow(()->new RuntimeException("Feedback Not Found"));
        feedbackRepository.deleteById(id);
        return id+" Feedback Delete Successfully";
    }
}