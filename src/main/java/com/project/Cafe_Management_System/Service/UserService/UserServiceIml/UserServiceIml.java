package com.project.Cafe_Management_System.Service.UserService.UserServiceIml;

import com.project.Cafe_Management_System.Dto.UserDto.DetailsResponesDto;
import com.project.Cafe_Management_System.Dto.UserDto.UserDto;
import com.project.Cafe_Management_System.Dto.UserDto.UserResponesDto;
import com.project.Cafe_Management_System.Entity.CustomerEntity.Customer;
import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import com.project.Cafe_Management_System.Entity.RoleEntity.Role;
import com.project.Cafe_Management_System.Entity.UserEntity.User;
import com.project.Cafe_Management_System.Mapper.UserMapper.DetailsMapper;
import com.project.Cafe_Management_System.Mapper.UserMapper.UserMapper;
import com.project.Cafe_Management_System.Repository.OrderRepository.OrderRepository;
import com.project.Cafe_Management_System.Repository.RoleRepository.RoleRepository;
import com.project.Cafe_Management_System.Repository.UserRepository.UserRepository;
import com.project.Cafe_Management_System.Service.UserService.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceIml implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final OrderRepository orderRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceIml(UserRepository userRepository, UserMapper userMapper, RoleRepository roleRepository, OrderRepository orderRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
        this.orderRepository = orderRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("No user with email: " + email));

        // Use ROLE_ prefix for Spring Security compatibility
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + u.getRole().getRole_name());

        return new org.springframework.security.core.userdetails.User(
                u.getEmail(),
                u.getPassword(),
                List.of(authority)
        );
    }
    public List<UserResponesDto> get_Data(){
        List<User> users=userRepository.findAll();
        return UserMapper.get_toDto(users);
    }
    public UserResponesDto user_Post_Data(UserDto userDto){
        Role role=roleRepository.findById(userDto.getRole_id()).orElseThrow(()-> new RuntimeException("Role Not Found"));

        User user=userMapper.toEntity(userDto,role);
        user=userRepository.save(user);
        return UserMapper.toDto(user);
    }
    public UserResponesDto put_Data(Integer id,UserDto userDto){

        User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Found"));
        if (userDto.getRole_id() != null) {
            Role role = roleRepository.findById(userDto.getRole_id())
                    .orElseThrow(() -> new RuntimeException("Role Not Found"));
            user.setRole(role);
        }
        UserMapper.toUpdate(userDto,user);
        User userSaved=userRepository.save(user);
        return UserMapper.toDto(userSaved);
    }
    public String user_Delete(Integer id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "Delete The Record Successfully: "+id;
        }
        return "User Id Not Found";
    }
    public DetailsResponesDto getDashboardDetails() {
        List<Order> orders = orderRepository.findAll();
        // Assuming you have a userRepository to get customer count
        int totalCustomers = (int) userRepository.count();

        return DetailsMapper.toDto(orders, totalCustomers);
    }
}
