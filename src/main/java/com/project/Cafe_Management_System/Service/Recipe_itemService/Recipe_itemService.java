package com.project.Cafe_Management_System.Service.Recipe_itemService;

import com.project.Cafe_Management_System.Dto.Recipe_itemDto.Recipe_itemDto;
import com.project.Cafe_Management_System.Dto.Recipe_itemDto.Recipe_itemResponesDto;

import java.util.List;


public interface Recipe_itemService {
    public Recipe_itemResponesDto recipe_Post(Recipe_itemDto recipe_itemDto);
    public List<Recipe_itemResponesDto> recipe_Get();
    public Recipe_itemResponesDto recipe_Put(Integer id,Recipe_itemDto recipe_itemDto);
    public String recipe_Delete(Integer id);
}