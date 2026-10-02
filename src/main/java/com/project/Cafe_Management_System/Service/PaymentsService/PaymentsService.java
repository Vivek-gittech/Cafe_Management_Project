package com.project.Cafe_Management_System.Service.PaymentsService;

import com.project.Cafe_Management_System.Dto.PaymentsDto.PaymentsDto;
import com.project.Cafe_Management_System.Dto.PaymentsDto.PaymentsResponesDto;

import java.util.List;

public interface PaymentsService {

    public List<PaymentsResponesDto> payments_All_Get();
    public PaymentsResponesDto payments_Post(PaymentsDto paymentsDto);
    public PaymentsResponesDto payments_Put(Integer id,PaymentsDto paymentsDto);
    public String payments_Delete(Integer id);
}
