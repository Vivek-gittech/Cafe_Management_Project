package com.project.Cafe_Management_System.Dto.RoleDto;


import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class RoleDto {

    @Id
    private int role_id;

    @NotBlank(message="Role name required")
    private String role_name;

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
}
