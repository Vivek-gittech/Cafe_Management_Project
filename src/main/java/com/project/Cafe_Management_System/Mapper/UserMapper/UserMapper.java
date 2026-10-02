package com.project.Cafe_Management_System.Mapper.UserMapper;

import com.project.Cafe_Management_System.Dto.UserDto.UserDto;
import com.project.Cafe_Management_System.Dto.UserDto.UserResponesDto;
import com.project.Cafe_Management_System.Entity.RoleEntity.Role;
import com.project.Cafe_Management_System.Entity.UserEntity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User toEntity(UserDto userDto, Role role){
        if(userDto==null){
            return null;
        }
        User user=new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setRole(role);
        return user;
    }
    public static UserResponesDto toDto(User user){
        if(user==null){
            return null;
        }

        UserResponesDto userResDto=new UserResponesDto();
        userResDto.setUser_id(user.getUser_id());
        userResDto.setName(user.getName());
        userResDto.setEmail(user.getEmail());

        if(user.getRole()!=null){
            userResDto.setRole_id(user.getRole().getRole_id());
            userResDto.setRole_name(user.getRole().getRole_name());
        }
        return userResDto;
    }
    public static List<UserResponesDto> get_toDto(List<User> user){
        return user.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    public static void toUpdate(UserDto userDto,User user){
        if(userDto.getName() !=null){
            user.setName((userDto.getName()));
        }
        if(userDto.getEmail() != null){
            user.setEmail(userDto.getEmail());
        }
    }

}
