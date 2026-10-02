package com.project.Cafe_Management_System.Controller.LoginController;

import com.project.Cafe_Management_System.Dto.LoginDto.LoginDto;
import com.project.Cafe_Management_System.Service.LoginService.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Login/User")
//@PreAuthorize("hasRole('User')")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        boolean valid=loginService.validAdmin(loginDto.getEmail(), loginDto.getPassword());
        if(valid){
            return ResponseEntity.ok("Login Successfully");
        }
        return ResponseEntity.ok("Invalid Email and Password");
    }
}
