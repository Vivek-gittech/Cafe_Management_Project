package com.project.Cafe_Management_System.Repository.OrderRepository;

import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
}