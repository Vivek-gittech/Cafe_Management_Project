package com.project.Cafe_Management_System.Service.Order_itemService;

import com.project.Cafe_Management_System.Dto.Order_itemDto.Order_itemDto;
import com.project.Cafe_Management_System.Dto.Order_itemDto.Order_itemResponesDto;
import com.project.Cafe_Management_System.Repository.Order_itemRepository.Order_itemRepository;

import java.util.List;

public interface Order_itemService {

    List<Order_itemResponesDto> order_item_Get();
    Order_itemResponesDto order_item_Post(Order_itemDto order_itemDto);
    String order_item_Put(Integer id,Order_itemDto order_itemDto);
    String order_item_Delete(Integer id);
}