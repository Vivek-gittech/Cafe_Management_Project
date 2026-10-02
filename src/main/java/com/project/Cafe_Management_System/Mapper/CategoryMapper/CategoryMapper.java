package com.project.Cafe_Management_System.Mapper.CategoryMapper;

import com.project.Cafe_Management_System.Dto.CategoryDto.CategoryDto;
import com.project.Cafe_Management_System.Dto.CategoryDto.CategoryResponesDto;
import com.project.Cafe_Management_System.Entity.CategoryEntity.Category;
import com.project.Cafe_Management_System.Mapper.CustomerMapper.CustomerMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public static List<CategoryResponesDto> to_Get_Dto(List<Category> category){
        return category.stream()
                .map(CategoryMapper::to_Dto)
                .collect(Collectors.toList());
    }
    public static Category to_Entity(CategoryDto categoryDto){
        Category category=new Category();
        category.setCategory_id(categoryDto.getCategory_id());
        category.setCategory_name(categoryDto.getCategory_name());
        return category;
    }
    public static CategoryResponesDto to_Dto(Category category){
        CategoryResponesDto categoryResponesDto=new CategoryResponesDto();
        categoryResponesDto.setCategory_name(category.getCategory_name());
        return categoryResponesDto;
    }
    public static void to_Update_Entity(CategoryDto categoryDto,Category category){
        if(categoryDto.getCategory_name()!=null){
            category.setCategory_name(categoryDto.getCategory_name());
        }
    }
}
