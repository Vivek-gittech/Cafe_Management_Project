package com.project.Cafe_Management_System.Controller.AuthController;

import com.project.Cafe_Management_System.Config.JwtUtil;
import com.project.Cafe_Management_System.Dto.LoginDto.LoginDto;
import com.project.Cafe_Management_System.Entity.CustomerEntity.Customer;
import com.project.Cafe_Management_System.Entity.RoleEntity.Role;
import com.project.Cafe_Management_System.Entity.UserEntity.User;
import com.project.Cafe_Management_System.Repository.CustomerRepository.CustomerRepository;
import com.project.Cafe_Management_System.Repository.UserRepository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

        private final AuthenticationManager authManager;
        private final JwtUtil jwtUtil;
        private final UserRepository userRepo;
        private final CustomerRepository customerRepository;

        public AuthController(AuthenticationManager authManager, JwtUtil jwtUtil, UserRepository userRepo, CustomerRepository customerRepository) {
                this.authManager = authManager;
                this.jwtUtil = jwtUtil;
                this.userRepo = userRepo;
                this.customerRepository = customerRepository;
        }

        record LoginRequest(String email, String password) {}

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody LoginDto req) {
                // 1. Authenticate via Spring Security
                authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));

                String roleName;
                String name;
                int user_id;

                // 2. Try to find the person in the User table first
                var userOpt = userRepo.findByEmail(req.getEmail());

                if (userOpt.isPresent()) {
                        User user = userOpt.get();
                        roleName = user.getRole().getRole_name();
                        name = user.getName();
                        user_id = user.getUser_id();
                } else {
                        // 3. If not in User, check Customer table
                        Customer customer = customerRepository.findByUsername(req.getEmail())
                                .orElseThrow(() -> new RuntimeException("Account not found in any record"));

                        roleName = "CUSTOMER"; // Or customer.getRole()...
                        name = customer.getName();
                        user_id = customer.getCustomer_id();
                }

                // 4. Generate Token and Response
                String token = jwtUtil.generateToken(req.getEmail(), roleName);

                return ResponseEntity.ok(Map.of(
                        "token", token,
                        "role", roleName,
                        "name", name,
                        "user_id", user_id
                ));
        }
}
