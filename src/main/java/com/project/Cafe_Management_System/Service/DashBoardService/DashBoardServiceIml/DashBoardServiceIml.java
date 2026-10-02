package com.project.Cafe_Management_System.Service.DashBoardService.DashBoardServiceIml;

import com.project.Cafe_Management_System.Dto.UserDto.DetailsResponesDto;
import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import com.project.Cafe_Management_System.Mapper.UserMapper.DetailsMapper;
import com.project.Cafe_Management_System.Repository.CustomerRepository.CustomerRepository;
import com.project.Cafe_Management_System.Repository.OrderRepository.OrderRepository;
import com.project.Cafe_Management_System.Repository.UserRepository.UserRepository;
import com.project.Cafe_Management_System.Service.DashBoardService.DashBoardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashBoardServiceIml implements DashBoardService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public DashBoardServiceIml(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public DetailsResponesDto getDashboardDetails() {
        List<Order> orders = orderRepository.findAll();
        // Assuming you have a userRepository to get customer count
        int totalCustomers = (int) customerRepository.count();

        return DetailsMapper.toDto(orders, totalCustomers);
    }
}
