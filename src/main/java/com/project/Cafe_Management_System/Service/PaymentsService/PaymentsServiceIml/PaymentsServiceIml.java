package com.project.Cafe_Management_System.Service.PaymentsService.PaymentsServiceIml;

import com.project.Cafe_Management_System.Dto.PaymentsDto.PaymentsDto;
import com.project.Cafe_Management_System.Dto.PaymentsDto.PaymentsResponesDto;
import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import com.project.Cafe_Management_System.Entity.PaymentsEntity.Payments;
import com.project.Cafe_Management_System.Mapper.PaymentsMapper.PaymentsMapper;
import com.project.Cafe_Management_System.Repository.OrderRepository.OrderRepository;
import com.project.Cafe_Management_System.Repository.PaymentsRepository.PaymentsRepository;
import com.project.Cafe_Management_System.Service.PaymentsService.PaymentsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsServiceIml implements PaymentsService {
    private final PaymentsRepository paymentsRepository;
    private final PaymentsMapper paymentsMapper;
    private final OrderRepository orderRepository;

    public PaymentsServiceIml(PaymentsRepository paymentsRepository, PaymentsMapper paymentsMapper, OrderRepository orderRepository) {
        this.paymentsRepository = paymentsRepository;
        this.paymentsMapper = paymentsMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<PaymentsResponesDto> payments_All_Get(){
        List<Payments> payments=paymentsRepository.findAll();
        return PaymentsMapper.to_All_Dto(payments);
    }
    public PaymentsResponesDto payments_Post(PaymentsDto paymentsDto){
        Order order=orderRepository.findById(paymentsDto.getOrder_id()).orElseThrow(()->new RuntimeException("Order Not Found"));
        Payments payments=PaymentsMapper.to_Entity(paymentsDto,order);
        Payments paymentsSaved=paymentsRepository.save(payments);
        return PaymentsMapper.to_Dto(paymentsSaved);
    }
    public PaymentsResponesDto payments_Put(Integer Id,PaymentsDto paymentsDto){
        Payments payments=paymentsRepository.findById(Id).orElseThrow(()->new RuntimeException("Payments Not Found"));
        PaymentsMapper.to_Put_Entity(payments,paymentsDto);
        Payments paymentsSaved=paymentsRepository.save(payments);
        return PaymentsMapper.to_Dto(paymentsSaved);
    }
    public String payments_Delete(Integer id){
        Payments payments=paymentsRepository.findById(id).orElseThrow(()->new RuntimeException("Payments Not Found"));
        paymentsRepository.deleteById(id);
        return id+"Delete Payments Successfully";
    }
}