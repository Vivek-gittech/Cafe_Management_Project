package com.project.Cafe_Management_System.Controller.CustomerController;

import com.project.Cafe_Management_System.Dto.CustomerDto.CustomerDto;
import com.project.Cafe_Management_System.Dto.CustomerDto.CustomerResponesDto;
import com.project.Cafe_Management_System.Service.CustomerService.CustomerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
@PreAuthorize("hasAnyRole('Admin','Manager'))")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //Get All Customer
    @GetMapping("/Get")
    public List<CustomerResponesDto> get_Customer(){
        return customerService.get_Customer();
    }

    //Insert The New Customer
    @PostMapping("/Post")
    public CustomerResponesDto create_customer(@RequestBody CustomerDto customerDto){
        return customerService.post_Customer(customerDto);
    }

    //Update The Customer using customer_id
    @PutMapping("/Update/{id}")
    public String Update_Customer(@PathVariable Integer id,@RequestBody CustomerDto customerDto){
        return customerService.put_Customer(id,customerDto);
    }

    //Delete The Customer using customer_id
    @DeleteMapping("/Delete/{id}")
    public String Delete_Customer(@PathVariable Integer id){
        return customerService.delete_Customer(id);
    }
}