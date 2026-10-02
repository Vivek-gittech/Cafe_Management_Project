package com.project.Cafe_Management_System.Service.RoleService;
import com.project.Cafe_Management_System.Dto.RoleDto.RoleDto;
import com.project.Cafe_Management_System.Dto.RoleDto.RoleResponesDto;

import java.util.List;

public interface RoleService {
    List<RoleResponesDto> get_Roles();
    RoleResponesDto role_Post_Data(RoleDto roleDto);
    String put_Role(Integer id,RoleDto roleDto);
    String delete_Role(Integer id);
}