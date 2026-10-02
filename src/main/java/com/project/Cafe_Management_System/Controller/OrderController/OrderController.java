package com.project.Cafe_Management_System.Controller.OrderController;

import com.project.Cafe_Management_System.Dto.OrderDto.OrderDto;
import com.project.Cafe_Management_System.Dto.OrderDto.OrderPatchDto;
import com.project.Cafe_Management_System.Dto.OrderDto.OrderResponesDto;
import com.project.Cafe_Management_System.Service.OrderService.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Order")
@PreAuthorize("hasAnyRole('Admin','Waiter')")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //Get All Order
    @GetMapping("/Get")
    public List<OrderResponesDto> order_Get(){
        return orderService.order_Get();
    }

    //Get All Active
    @GetMapping("/Active/Get")
    public List<OrderResponesDto> order_Active_Get(){
        return orderService.orderActiveGet();
    }

    //Insert New Record Order
    @PostMapping("/Post")
    public OrderResponesDto order_Post(@RequestBody OrderDto orderDto) {
        return orderService.order_Post(orderDto);
    }


    //Update The Order using id
    @PatchMapping("/Update/{id}")
    public String order_Put(@PathVariable Integer id,@RequestBody OrderPatchDto orderPatchDto){
        return orderService.order_Put(id,orderPatchDto);
    }

    //Delete Order Using id
    @DeleteMapping("/Delete/{id}")
    public String order_Delete(@PathVariable Integer id){
        return orderService.order_Delete(id);
    }
}