package com.project.Cafe_Management_System.Repository.Recipe_itemRepository;

import com.project.Cafe_Management_System.Entity.Recipe_itemEntity.Recipe_item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Recipe_itemRepository extends JpaRepository<Recipe_item,Integer> {
}
