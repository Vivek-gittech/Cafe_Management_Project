package com.project.Cafe_Management_System.Service.CustomerService;

import com.project.Cafe_Management_System.Dto.CustomerDto.CustomerDto;
import com.project.Cafe_Management_System.Dto.CustomerDto.CustomerResponesDto;

import java.util.List;


public interface CustomerService {

    List<CustomerResponesDto> get_Customer();
    CustomerResponesDto post_Customer(CustomerDto customerDto);
    String put_Customer(Integer id,CustomerDto customerDto);
    String delete_Customer(Integer id);
}
