package com.project.Cafe_Management_System.Controller.order_itemController;

import com.project.Cafe_Management_System.Dto.Order_itemDto.Order_itemDto;
import com.project.Cafe_Management_System.Dto.Order_itemDto.Order_itemResponesDto;
import com.project.Cafe_Management_System.Service.Order_itemService.Order_itemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Order_item")
public class Order_itemController {
    private final Order_itemService order_itemService;

    public Order_itemController(Order_itemService order_itemService) {
        this.order_itemService = order_itemService;
    }

    @GetMapping("/Get")
    public List<Order_itemResponesDto> order_item_Get(){
        return order_itemService.order_item_Get();
    }
    @PostMapping("/Post")
    public Order_itemResponesDto order_item_Post(@RequestBody Order_itemDto order_itemDto){
        return order_itemService.order_item_Post(order_itemDto);
    }
    @PutMapping("/Update/{id}")
    public String order_item_Put(@PathVariable Integer id,@RequestBody Order_itemDto order_itemDto){
        return order_itemService.order_item_Put(id,order_itemDto);
    }
    @DeleteMapping("/Delete/{id}")
    public String order_item_Delete(@PathVariable Integer id){
        return order_itemService.order_item_Delete(id);
    }
}