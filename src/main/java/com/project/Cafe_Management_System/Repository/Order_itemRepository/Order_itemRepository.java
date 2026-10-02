package com.project.Cafe_Management_System.Repository.Order_itemRepository;

import com.project.Cafe_Management_System.Entity.Order_itemEntity.Order_item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_itemRepository extends JpaRepository<Order_item,Integer> {
}
