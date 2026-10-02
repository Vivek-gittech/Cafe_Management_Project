package com.project.Cafe_Management_System.Service.LoginService.LoginServiceIml;

import com.project.Cafe_Management_System.Dto.LoginDto.LoginDto;
import com.project.Cafe_Management_System.Entity.UserEntity.User;
import com.project.Cafe_Management_System.Repository.UserRepository.UserRepository;
import com.project.Cafe_Management_System.Service.LoginService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceIml implements LoginService {
    private final UserRepository userRepository;

    public LoginServiceIml(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean validAdmin(String email,String password){

        User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User Not Found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        if (user == null) {
            System.out.println("Email Not Found "+email);
            return false; // user not found
        }
        System.out.println("User Email"+passwordEncoder.matches(password, user.getPassword()));
        System.out.println("User Email"+user.getEmail());
        if(email.equals(user.getEmail()) && passwordEncoder.matches(password, user.getPassword())){
            return email.equals(user.getEmail()) && passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
}