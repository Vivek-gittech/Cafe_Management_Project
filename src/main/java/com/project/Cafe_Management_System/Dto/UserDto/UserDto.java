package com.project.Cafe_Management_System.Dto.UserDto;

import org.springframework.stereotype.Component;

@Component
public class UserDto {
    private String name;
    private String email;
    private String password;
    private Integer role_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
