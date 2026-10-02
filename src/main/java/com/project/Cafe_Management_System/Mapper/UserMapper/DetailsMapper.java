package com.project.Cafe_Management_System.Mapper.UserMapper;

import com.project.Cafe_Management_System.Dto.UserDto.DetailsResponesDto;
import com.project.Cafe_Management_System.Dto.UserDto.UserResponesDto;
import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import com.project.Cafe_Management_System.Entity.UserEntity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DetailsMapper {

    public static DetailsResponesDto toDto(List<Order> orders, int totalCustomers) {
        DetailsResponesDto dto = new DetailsResponesDto();

        double totalBill = 0;
        int pending = 0;
        int complete = 0;
        int cancel = 0;

        for (Order order : orders) {
            totalBill += order.getTotal_amount(); // Assuming Order has this field

            // Logic for status counts (Adjust strings/enums to match your Order entity)
            if ("PENDING".equalsIgnoreCase(order.getOrder_status())) pending++;
            else if ("COMPLETE".equalsIgnoreCase(order.getOrder_status())) complete++;
            else if ("CANCEL".equalsIgnoreCase(order.getOrder_status())) cancel++;
        }

        dto.setTotalBill(totalBill);
        dto.setTotalCustomer(totalCustomers);
        dto.setTotalPendingOrder(pending);
        dto.setTotalCompleteOrder(complete);
        dto.setTotalCancelOrder(cancel);

        return dto;
    }
}