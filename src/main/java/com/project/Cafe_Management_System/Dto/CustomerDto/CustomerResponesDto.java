package com.project.Cafe_Management_System.Dto.CustomerDto;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class CustomerResponesDto {

    @Id
    private String city;
    private String name;
    private String username;
    private String message;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
