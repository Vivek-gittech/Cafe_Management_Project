package com.project.Cafe_Management_System.Mapper.CustomerMapper;

import com.project.Cafe_Management_System.Dto.CustomerDto.CustomerDto;
import com.project.Cafe_Management_System.Dto.CustomerDto.CustomerResponesDto;
import com.project.Cafe_Management_System.Entity.CustomerEntity.Customer;
import com.project.Cafe_Management_System.Mapper.UserMapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public static Customer to_Entity(CustomerDto customerDto){
        Customer customer=new Customer();
        customer.setCity(customerDto.getCity());
        customer.setName(customerDto.getName());
        customer.setUsername(customerDto.getUsername());
        customer.setPassword(customerDto.getPassword());
        return customer;
    }
    public static CustomerResponesDto to_Dto(Customer customer){
        CustomerResponesDto customerResponesDto=new CustomerResponesDto();
        customerResponesDto.setCity(customer.getCity());
        customerResponesDto.setName(customer.getName());
        customerResponesDto.setUsername(customer.getUsername());
        return customerResponesDto;
    }
    public static List<CustomerResponesDto> to_Get_Dto(List<Customer> customer) {
        return customer.stream()
                .map(CustomerMapper::to_Dto)
                .collect(Collectors.toList());
    }
        public static void to_Put(CustomerDto customerDto,Customer customer){
            if(customerDto.getName()!=null){
                customer.setName(customerDto.getName());
            }
            if(customerDto.getCity()!=null){
                customer.setCity(customerDto.getCity());
            }
            if(customerDto.getUsername()!=null){
                customer.setUsername(customerDto.getUsername());
            }
            if(customerDto.getPassword()!=null){
                customer.setPassword(customerDto.getPassword());
            }
        }
}
