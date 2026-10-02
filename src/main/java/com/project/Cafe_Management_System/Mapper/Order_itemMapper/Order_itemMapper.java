package com.project.Cafe_Management_System.Mapper.Order_itemMapper;

import com.project.Cafe_Management_System.Dto.Order_itemDto.Order_itemDto;
import com.project.Cafe_Management_System.Dto.Order_itemDto.Order_itemResponesDto;
import com.project.Cafe_Management_System.Entity.Menu_itemEntity.Menu_item;
import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import com.project.Cafe_Management_System.Entity.Order_itemEntity.Order_item;
import com.project.Cafe_Management_System.Mapper.Menu_itemMapper.Menu_itemMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Order_itemMapper {

    public static List<Order_itemResponesDto> to_Dto_All(List<Order_item> order_item){
        return order_item.stream()
                .map(Order_itemMapper::to_Dto)
                .collect(Collectors.toList());
    }

    public static Order_item to_Entity(Order_itemDto order_itemDto,Menu_item menu_item,Order order,double subtotal){
        Order_item orderItem=new Order_item();
        orderItem.setMenu_item(menu_item);
        orderItem.setOrder(order);
        orderItem.setSubtotalPrice(subtotal);
        orderItem.setQuantity(order_itemDto.getQuantity());
        return orderItem;
    }
    public static Order_itemResponesDto to_Dto(Order_item order_item){
        Order_itemResponesDto orderItemResponesDto=new Order_itemResponesDto();
        orderItemResponesDto.setOrder_item_id(order_item.getOrder_item_id());
        orderItemResponesDto.setItem_id(order_item.getMenu_item().getItem_id());
        orderItemResponesDto.setItem_name(order_item.getMenu_item().getItem_name());
        orderItemResponesDto.setOrder_id(order_item.getOrder().getOrder_id());
        orderItemResponesDto.setQuantity(order_item.getQuantity());
        orderItemResponesDto.setSubtotalPrice(order_item.getSubtotalPrice());
        orderItemResponesDto.setTotal_amount(order_item.getOrder().getTotal_amount());
        return orderItemResponesDto;
    }
    public static void to_Entity_Put(Order_item order_item, Order_itemDto order_itemDto,Menu_item menu_item,Order order){
        if(order_itemDto.getItem_id()!=null){
            order_item.setMenu_item(menu_item);
        }
        if(order_itemDto.getOrder_id()!=null){
            order_item.setOrder(order);
        }
        if(order_itemDto.getSubtotalPrice()!=null){
            order_item.setSubtotalPrice(order_itemDto.getSubtotalPrice());
        }
        if(order_itemDto.getQuantity()!=null){
            order_item.setQuantity(order_itemDto.getQuantity());
        }
    }
}

