package com.project.Cafe_Management_System.Controller.CategoryController;

import com.project.Cafe_Management_System.Dto.CategoryDto.CategoryDto;
import com.project.Cafe_Management_System.Dto.CategoryDto.CategoryResponesDto;
import com.project.Cafe_Management_System.Service.CategoryService.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    //Category Find All
    @GetMapping("/Get")
    public List<CategoryResponesDto>category_Get(){
        return categoryService.category_GetAll();
    }

    //Category New Insert
    @PostMapping("/Post")
    public CategoryResponesDto category_Add(@RequestBody CategoryDto categoryDto){
        System.out.println("Controller :"+categoryDto.getCategory_name());
        return categoryService.category_Insert(categoryDto);
    }

    //Category Update Using id
    @PutMapping("/Update/{id}")
    public String category_Update(@PathVariable Integer id,@RequestBody CategoryDto categoryDto){
        return categoryService.category_put(id,categoryDto);
    }

    //Category Delete Using id
    @DeleteMapping("/Delete/{id}")
    public String category_Delete(@PathVariable Integer id){
        return categoryService.category_Delete(id);
    }
}
