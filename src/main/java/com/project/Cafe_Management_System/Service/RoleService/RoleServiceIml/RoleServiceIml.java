package com.project.Cafe_Management_System.Service.RoleService.RoleServiceIml;

import com.project.Cafe_Management_System.Dto.RoleDto.RoleDto;
import com.project.Cafe_Management_System.Dto.RoleDto.RoleResponesDto;
import com.project.Cafe_Management_System.Entity.RoleEntity.Role;
import com.project.Cafe_Management_System.Mapper.RoleMapper.RoleMapper;
import com.project.Cafe_Management_System.Repository.RoleRepository.RoleRepository;
import com.project.Cafe_Management_System.Service.RoleService.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceIml implements RoleService{

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceIml(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleResponesDto> get_Roles(){
        List<Role> role=roleRepository.findAll();
        return RoleMapper.get_Role_toDto(role);
    }
    public RoleResponesDto role_Post_Data(RoleDto roleDto){
        Role role=RoleMapper.toEntity(roleDto);
        role=roleRepository.save(role);
        return RoleMapper.toDto(role);
    }
    public String put_Role(Integer id,RoleDto roleDto){
        Role role=roleRepository.findById(id).orElseThrow(()-> new RuntimeException("Role Not Found"));
        if(!roleRepository.existsById(id)){
            return "Role Not Found";
        }
        RoleMapper.put_Role(roleDto,role);
        roleRepository.save(role);
        return "Role Updates Successfully";
    }
    public String delete_Role(Integer id){
        if(!roleRepository.existsById(id)){
            return "Role Not Found";
        }
        roleRepository.deleteById(id);
        return "Role Delete Successfully";
    }
}
