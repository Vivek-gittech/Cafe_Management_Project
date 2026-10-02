package com.project.Cafe_Management_System.Service.CategoryService;

import com.project.Cafe_Management_System.Dto.CategoryDto.CategoryDto;
import com.project.Cafe_Management_System.Dto.CategoryDto.CategoryResponesDto;

import java.util.List;


public interface CategoryService {
    List<CategoryResponesDto> category_GetAll();
    CategoryResponesDto category_Insert(CategoryDto categoryDto);
    String category_put(Integer id,CategoryDto categoryDto);
    String category_Delete(Integer id);
}
