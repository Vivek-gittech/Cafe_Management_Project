package com.project.Cafe_Management_System.Repository.RoleRepository;
import com.project.Cafe_Management_System.Entity.RoleEntity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}