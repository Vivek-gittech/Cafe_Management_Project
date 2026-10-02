package com.project.Cafe_Management_System.Service.CategoryService.CategoryServiceIml;

import com.project.Cafe_Management_System.Dto.CategoryDto.CategoryDto;
import com.project.Cafe_Management_System.Dto.CategoryDto.CategoryResponesDto;
import com.project.Cafe_Management_System.Entity.CategoryEntity.Category;
import com.project.Cafe_Management_System.Mapper.CategoryMapper.CategoryMapper;
import com.project.Cafe_Management_System.Repository.CategoryRepository.CategoryRepository;
import com.project.Cafe_Management_System.Service.CategoryService.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceIml implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceIml(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryResponesDto> category_GetAll(){
            List<Category> category=categoryRepository.findAll();
            return CategoryMapper.to_Get_Dto(category);
    }
    public CategoryResponesDto category_Insert(CategoryDto categoryDto){
        Category category=CategoryMapper.to_Entity(categoryDto);
        categoryRepository.save(category);
        return CategoryMapper.to_Dto(category);
    }
    public String category_put(Integer id,CategoryDto categoryDto){
        Category category=categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category Not Found"));
        if(category==null){
            return "Category Not Found";
        }
        CategoryMapper.to_Update_Entity(categoryDto,category);
        categoryRepository.save(category);
        return "Category Updated";
    }
    public String category_Delete(Integer id){
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return id+" Category Deleted";
        }
        return "Category Not Found";
    }
}