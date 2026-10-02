package com.project.Cafe_Management_System.Service.LoginService;

import com.project.Cafe_Management_System.Dto.LoginDto.LoginDto;

public interface LoginService {
    public Boolean validAdmin(String email,String password);
}
