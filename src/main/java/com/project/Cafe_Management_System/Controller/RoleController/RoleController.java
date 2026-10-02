package com.project.Cafe_Management_System.Controller.RoleController;

import com.project.Cafe_Management_System.Dto.RoleDto.RoleDto;
import com.project.Cafe_Management_System.Dto.RoleDto.RoleResponesDto;
import com.project.Cafe_Management_System.Service.RoleService.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    //Get All Roles
    @GetMapping("/Get")
    public List<RoleResponesDto> get_Role(){
        return roleService.get_Roles();
    }

    //New Roles Insert
    @PostMapping("/Post")
    public RoleResponesDto create_Role(@RequestBody RoleDto roleDto){
        return roleService.role_Post_Data(roleDto);
    }

    //Update Roles In Roles_id
    @PutMapping("/Update/{id}")
    public String put_Roles(@PathVariable Integer id,@RequestBody RoleDto roleDto){
        return roleService.put_Role(id,roleDto);
    }

    //Role Delete Using Role_id
    @DeleteMapping("/Delete/{id}")
    public String delete_Role(@PathVariable Integer id){
        return roleService.delete_Role(id);
    }
}