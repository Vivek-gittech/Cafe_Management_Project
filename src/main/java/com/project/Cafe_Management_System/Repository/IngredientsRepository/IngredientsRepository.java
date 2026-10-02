package com.project.Cafe_Management_System.Repository.IngredientsRepository;

import com.project.Cafe_Management_System.Entity.IngredientsEntity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients,Integer> {
}
