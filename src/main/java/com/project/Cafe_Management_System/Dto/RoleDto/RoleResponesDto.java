package com.project.Cafe_Management_System.Dto.RoleDto;

import com.project.Cafe_Management_System.Dto.UserDto.UserDto;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleResponesDto {

    private int role_id;
    private String role_name;
//    private List<UserDto> user;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

//    public List<UserDto> getUser() {
//        return user;
//    }
//
//    public void setUser(List<UserDto> user) {
//        this.user = user;
//    }
}
