package com.project.Cafe_Management_System.Mapper.OrderMapper;

import com.project.Cafe_Management_System.Dto.OrderDto.OrderDto;
import com.project.Cafe_Management_System.Dto.OrderDto.OrderPatchDto;
import com.project.Cafe_Management_System.Dto.OrderDto.OrderResponesDto;
import com.project.Cafe_Management_System.Entity.CustomerEntity.Customer;
import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import com.project.Cafe_Management_System.Entity.UserEntity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public static List<OrderResponesDto> order_Get(List<Order> order){
        return order.stream()
                .map(OrderMapper::to_Dto)
                .collect(Collectors.toList());
    }
    public static Order to_Entity(OrderDto orderDto, User user,Customer customer){
        Order order=new Order();
        order.setCustomer(customer);
        order.setTable_number(orderDto.getTable_number());
        order.setTotal_amount(orderDto.getTotal_amount());
        order.setWaiter(user);
        order.setCreate_at(LocalDateTime.now());
        order.setUpdate_at(LocalDateTime.now());
        return order;
    }
    public static OrderResponesDto to_Dto(Order order){
        OrderResponesDto orderResponesDto=new OrderResponesDto();
        orderResponesDto.setOrder_id(order.getOrder_id());
        orderResponesDto.setCustomer_name(order.getCustomer().getName());
        orderResponesDto.setWaiter_id(order.getWaiter().getUser_id());
        orderResponesDto.setWaiter_name(order.getWaiter().getName());
        orderResponesDto.setOrder_status(order.getOrder_status());
        orderResponesDto.setTable_number(order.getTable_number());
        orderResponesDto.setTotal_amount(order.getTotal_amount());
        orderResponesDto.setCreate_at(order.getCreate_at());
        return orderResponesDto;
    }
//    public static void to_Entity_Put(OrderDto orderDto,User user,Order order,Customer customer){
//        if(orderDto.getWaiter_id()!=null){
//            order.setWaiter(user);
//        }
//        if(orderDto.getOrder_status()!=null){
//            order.setOrder_status(orderDto.getOrder_status());
//        }
//        if(orderDto.getTotal_amount()!=null){
//            order.setTotal_amount(orderDto.getTotal_amount());
//        }
//        if(orderDto.getTable_number()!=null){
//            order.setTable_number(orderDto.getTable_number());
//        }
//        if(orderDto.getCustomer_id()!=null){
//            order.setCustomer(customer);
//        }
//        order.setUpdate_at(LocalDateTime.now());
//    }

    public static void to_Entity_Put(OrderPatchDto orderPatchDto,Order order,User user){

        if(orderPatchDto.getOrder_status()!=null){
            order.setOrder_status(orderPatchDto.getOrder_status());
        }
        if(orderPatchDto.getWaiter_id()!=null){
            order.setWaiter(user);
        }
        order.setUpdate_at(LocalDateTime.now());
    }
    public static List<OrderResponesDto> orderActiveGet(List<Order> order){
        return order.stream()
                .filter(pending->pending.getOrder_status().equals("Pending"))
                .map(OrderMapper::to_Dto)
                .collect(Collectors.toList());
    }
}