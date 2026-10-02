package com.project.Cafe_Management_System.Service.CustomerService.CustomerServiceIml;

import com.project.Cafe_Management_System.Dto.CustomerDto.CustomerDto;
import com.project.Cafe_Management_System.Dto.CustomerDto.CustomerResponesDto;
import com.project.Cafe_Management_System.Entity.CustomerEntity.Customer;
import com.project.Cafe_Management_System.Mapper.CustomerMapper.CustomerMapper;
import com.project.Cafe_Management_System.Repository.CustomerRepository.CustomerRepository;
import com.project.Cafe_Management_System.Service.CustomerService.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIml implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceIml(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }
    @Override
    public List<CustomerResponesDto> get_Customer(){
        List<Customer> customer=customerRepository.findAll();
        return customerMapper.to_Get_Dto(customer);
    }
    public CustomerResponesDto post_Customer(CustomerDto customerDto){
        CustomerResponesDto customerResponesDto=new CustomerResponesDto();
        Customer customer=customerMapper.to_Entity(customerDto);
        customer=customerRepository.save(customer);
        customerResponesDto.setMessage("Data Insert Successfully");
        return customerMapper.to_Dto(customer);
    }
    public String put_Customer(Integer id,CustomerDto customerDto){
        Customer customer=customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer Not Found"));
        if(!customerRepository.existsById(id)){
            return "Customer Not Found";
        }
        CustomerMapper.to_Put(customerDto,customer);
        customerRepository.save(customer);
        return "Customer Update Successfully";
    }
    public String delete_Customer(Integer id){
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            return id+" is Record Delete Successfully";
        }
        return "Customer "+id+" Id Not Found";
    }
}
