package com.project.Cafe_Management_System.Mapper.RoleMapper;

import com.project.Cafe_Management_System.Dto.RoleDto.RoleDto;
import com.project.Cafe_Management_System.Dto.RoleDto.RoleResponesDto;
import com.project.Cafe_Management_System.Entity.RoleEntity.Role;
import com.project.Cafe_Management_System.Mapper.UserMapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleMapper {



    public static Role toEntity(RoleDto roleDto){
        Role role=new Role();
        role.setRole_name(roleDto.getRole_name());
        System.out.println("RoleDto"+roleDto.getRole_name());
        return role;
    }
    public static RoleResponesDto toDto(Role role){
        RoleResponesDto roleResponesDto=new RoleResponesDto();
        roleResponesDto.setRole_id(role.getRole_id());
        roleResponesDto.setRole_name(role.getRole_name());
        return roleResponesDto;
    }
    public static List<RoleResponesDto> get_Role_toDto(List<Role> role){
        return role.stream()
                .map(RoleMapper::toDto)
                .collect(Collectors.toList());
    }
    public static void put_Role(RoleDto roleDto,Role role){
        if(roleDto.getRole_name()!=null){
            role.setRole_name(roleDto.getRole_name());
        }
    }
}
