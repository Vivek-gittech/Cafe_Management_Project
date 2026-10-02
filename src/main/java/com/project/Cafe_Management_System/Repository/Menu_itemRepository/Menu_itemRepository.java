package com.project.Cafe_Management_System.Repository.Menu_itemRepository;

import com.project.Cafe_Management_System.Entity.Menu_itemEntity.Menu_item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Menu_itemRepository extends JpaRepository<Menu_item,Integer> {
}
