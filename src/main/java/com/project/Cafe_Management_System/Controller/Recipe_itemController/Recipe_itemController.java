package com.project.Cafe_Management_System.Controller.Recipe_itemController;

import com.project.Cafe_Management_System.Dto.Recipe_itemDto.Recipe_itemDto;
import com.project.Cafe_Management_System.Dto.Recipe_itemDto.Recipe_itemResponesDto;
import com.project.Cafe_Management_System.Service.Recipe_itemService.Recipe_itemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Recipe")
public class Recipe_itemController {
    private final Recipe_itemService recipe_itemService;

    public Recipe_itemController(Recipe_itemService recipe_itemService) {
        this.recipe_itemService = recipe_itemService;
    }

    @GetMapping("/Get")
    public List<Recipe_itemResponesDto> recipe_item_Get(){
        return recipe_itemService.recipe_Get();
    }
    @PostMapping("/Post")
    public Recipe_itemResponesDto recipe_item_Insert(@RequestBody Recipe_itemDto recipe_itemDto){
        return recipe_itemService.recipe_Post(recipe_itemDto);
    }
    @PutMapping("/Update/{id}")
    public Recipe_itemResponesDto recipe_item_Update(@PathVariable Integer id,@RequestBody Recipe_itemDto recipe_itemDto){
        return recipe_itemService.recipe_Put(id,recipe_itemDto);
    }
    @DeleteMapping("/Delete/{id}")
    public String recipe_item_Delete(@PathVariable Integer id){
        return recipe_itemService.recipe_Delete(id);
    }

}
