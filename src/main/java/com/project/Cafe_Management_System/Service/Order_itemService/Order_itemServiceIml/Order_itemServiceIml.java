package com.project.Cafe_Management_System.Service.Order_itemService.Order_itemServiceIml;

import com.project.Cafe_Management_System.Dto.Order_itemDto.Order_itemDto;
import com.project.Cafe_Management_System.Dto.Order_itemDto.Order_itemResponesDto;
import com.project.Cafe_Management_System.Entity.Menu_itemEntity.Menu_item;
import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import com.project.Cafe_Management_System.Entity.Order_itemEntity.Order_item;
import com.project.Cafe_Management_System.Mapper.Order_itemMapper.Order_itemMapper;
import com.project.Cafe_Management_System.Repository.Menu_itemRepository.Menu_itemRepository;
import com.project.Cafe_Management_System.Repository.OrderRepository.OrderRepository;
import com.project.Cafe_Management_System.Repository.Order_itemRepository.Order_itemRepository;
import com.project.Cafe_Management_System.Service.Order_itemService.Order_itemService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Order_itemServiceIml implements Order_itemService{
    private final Order_itemRepository order_itemRepository;
    private final Order_itemMapper order_itemMapper;
    private final OrderRepository orderRepository;
    private final Menu_itemRepository menu_itemRepository;

    public Order_itemServiceIml(Order_itemRepository order_itemRepository, Order_itemMapper order_itemMapper, OrderRepository orderRepository, Menu_itemRepository menu_itemRepository) {
        this.order_itemRepository = order_itemRepository;
        this.order_itemMapper = order_itemMapper;
        this.orderRepository = orderRepository;
        this.menu_itemRepository = menu_itemRepository;
    }

    @Override
    public List<Order_itemResponesDto> order_item_Get(){
        List<Order_item> order_items=order_itemRepository.findAll();
        return Order_itemMapper.to_Dto_All(order_items);
    }
    public Order_itemResponesDto order_item_Post(Order_itemDto order_itemDto){
        System.out.println("Menu_id"+order_itemDto.getItem_id());
        Order order=orderRepository.findById(order_itemDto.getOrder_id()).orElseThrow(()->new RuntimeException("Order Not Found"));
        Menu_item menu_item=menu_itemRepository.findById(order_itemDto.getItem_id()).orElseThrow(()->new RuntimeException("Menu Item Not Found"));
        double subtotal=totalPrice(menu_item,order_itemDto);
        Order_item order_item=Order_itemMapper.to_Entity(order_itemDto,menu_item,order,subtotal);
        order_item.setSubtotalPrice(subtotal);
        Order_item order_itemSvaed=order_itemRepository.save(order_item);
        return Order_itemMapper.to_Dto(order_itemSvaed);
    }
    public String order_item_Put(Integer id,Order_itemDto order_itemDto){
        Order_item order_item=order_itemRepository.findById(id).orElseThrow(()->new RuntimeException("Order Not Found"));
        Menu_item menu_item=menu_itemRepository.findById(order_itemDto.getItem_id()).orElseThrow(()->new RuntimeException("Menu Item Not Found"));
        Order order=orderRepository.findById(order_itemDto.getOrder_id()).orElseThrow(()->new RuntimeException("Order Not Found"));
        Order_itemMapper.to_Entity_Put(order_item,order_itemDto,menu_item,order);
        order_itemRepository.save(order_item);
        return id+"Order_item Update Successfully";
    }
    public String order_item_Delete(Integer id){
        if(order_itemRepository.existsById(id)){
            order_itemRepository.deleteById(id);
            return id+"Order_item Delete Successfully";
        }
        return id+"Order_item Not Found";
    }
    public double totalPrice(Menu_item menu_item,Order_itemDto order_itemDto){
        double subtotal=menu_item.getPrice()*order_itemDto.getQuantity();
        return subtotal;
    }
}
