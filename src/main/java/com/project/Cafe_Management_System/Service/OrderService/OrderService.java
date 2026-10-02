package com.project.Cafe_Management_System.Service.OrderService;

import com.project.Cafe_Management_System.Dto.OrderDto.OrderDto;
import com.project.Cafe_Management_System.Dto.OrderDto.OrderPatchDto;
import com.project.Cafe_Management_System.Dto.OrderDto.OrderResponesDto;

import java.util.List;

public interface OrderService {

    List<OrderResponesDto> order_Get();
    List<OrderResponesDto> orderActiveGet();
    OrderResponesDto order_Post(OrderDto orderDto);
    String order_Put(Integer id, OrderPatchDto ordeerPatchDto);
    String order_Delete(Integer id);
}