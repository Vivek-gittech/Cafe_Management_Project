package com.project.Cafe_Management_System.Repository.TokenRepository;


import com.project.Cafe_Management_System.Entity.TokenEntity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token,Integer> {
}
