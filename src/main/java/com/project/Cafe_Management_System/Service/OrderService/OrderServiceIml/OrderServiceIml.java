package com.project.Cafe_Management_System.Service.OrderService.OrderServiceIml;

import com.project.Cafe_Management_System.Dto.OrderDto.OrderDto;
import com.project.Cafe_Management_System.Dto.OrderDto.OrderPatchDto;
import com.project.Cafe_Management_System.Dto.OrderDto.OrderResponesDto;
import com.project.Cafe_Management_System.Entity.CategoryEntity.Category;
import com.project.Cafe_Management_System.Entity.CustomerEntity.Customer;
import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import com.project.Cafe_Management_System.Entity.UserEntity.User;
import com.project.Cafe_Management_System.Mapper.OrderMapper.OrderMapper;
import com.project.Cafe_Management_System.Repository.CustomerRepository.CustomerRepository;
import com.project.Cafe_Management_System.Repository.OrderRepository.OrderRepository;
import com.project.Cafe_Management_System.Repository.UserRepository.UserRepository;
import com.project.Cafe_Management_System.Service.OrderService.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceIml implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;


    public OrderServiceIml(OrderRepository orderRepository, OrderMapper orderMapper, UserRepository userRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<OrderResponesDto> order_Get(){
        List<Order> order=orderRepository.findAll();
        return OrderMapper.order_Get(order);
    }
    public List<OrderResponesDto> orderActiveGet(){
        List<Order> order=orderRepository.findAll();
        return OrderMapper.orderActiveGet(order);
    }
    public OrderResponesDto order_Post(OrderDto orderDto){
        System.out.println("Customer"+orderDto.getCustomer_id());
        System.out.println("Waiter"+orderDto.getWaiter_id());
        System.out.println("Total Amount"+orderDto.getTotal_amount());
        System.out.println("Order Status"+orderDto.getOrder_status());
        User user=userRepository.findById(orderDto.getWaiter_id()).orElseThrow(()->new RuntimeException("Waiter Not Found"));
        Customer customer=customerRepository.findById(orderDto.getCustomer_id()).orElseThrow(()->new RuntimeException("Customer Not Found"));
        Order order=OrderMapper.to_Entity(orderDto,user,customer);
        Order order_Saved=orderRepository.save(order);
        return OrderMapper.to_Dto(order_Saved);
    }
//    public String order_Put(Integer id, OrderPatchDto orderPatchDto){
//        System.out.println("Id"+id);
//        System.out.println("Order"+orderDto.getOrder_id());
//        System.out.println("User Id"+orderDto.getWaiter_id());
//        System.out.println("Status"+orderDto.getOrder_status());
//        User user=userRepository.findById(orderDto.getWaiter_id()).orElseThrow(()->new RuntimeException("User Not Found"));
//        Order order=orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order Not Found"));
//        Customer customer=customerRepository.findById(orderDto.getCustomer_id()).orElseThrow(()->new RuntimeException("Customer Not Found"));
//            order.setCreate_at(order.getCreate_at());
//            OrderMapper.to_Entity_Put(orderDto,user,order,customer);
//            orderRepository.save(order);
//            return id+"Update Successfully";
//    }
    public String order_Put(Integer id, OrderPatchDto orderPatchDto){
        Order order=orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order Not Found"));
        User user=userRepository.findById(orderPatchDto.getWaiter_id()).orElseThrow(()->new RuntimeException("Waiter Not Found"));
        OrderMapper.to_Entity_Put(orderPatchDto,order,user);
        orderRepository.save(order);
        return id+"Update Successfully";
    }
    public String order_Delete(Integer id){
        Order order=orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order Not Found"));
        orderRepository.deleteById(id);
        return id+"Order Delete Successfully";
    }
}