package com.project.Cafe_Management_System.Mapper.PaymentsMapper;

import com.project.Cafe_Management_System.Dto.PaymentsDto.PaymentsDto;
import com.project.Cafe_Management_System.Dto.PaymentsDto.PaymentsResponesDto;
import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import com.project.Cafe_Management_System.Entity.PaymentsEntity.Payments;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentsMapper {

    public static Payments to_Entity(PaymentsDto paymentsDto, Order order){
        Payments payments=new Payments();
        payments.setOrder(order);
        payments.setPayment_method(paymentsDto.getPayment_method());
        payments.setAmount_paid(order.getTotal_amount());
        payments.setPayment_date(LocalDateTime.now());
        return payments;
    }
    public static PaymentsResponesDto to_Dto(Payments payments){
        PaymentsResponesDto paymentsResponesDto=new PaymentsResponesDto();
        paymentsResponesDto.setOrder_id(payments.getOrder().getOrder_id());
        paymentsResponesDto.setAmount_paid(payments.getAmount_paid());
        paymentsResponesDto.setPayment_method(payments.getPayment_method());
        paymentsResponesDto.setPayment_date(payments.getPayment_date());
        return paymentsResponesDto;
    }
    public static List<PaymentsResponesDto> to_All_Dto(List<Payments> payments){
        return payments.stream()
                .map(PaymentsMapper::to_Dto)
                .collect(Collectors.toList());
    }
    public static void to_Put_Entity(Payments payments,PaymentsDto paymentsDto){
        payments.setOrder(payments.getOrder());
        payments.setPayment_method(paymentsDto.getPayment_method());
        payments.setPayment_date(LocalDateTime.now());
    }
}