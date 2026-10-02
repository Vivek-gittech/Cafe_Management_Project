package com.project.Cafe_Management_System.Controller.IngredientsController;

import com.project.Cafe_Management_System.Dto.IngredientsDto.IngredientsDto;
import com.project.Cafe_Management_System.Dto.IngredientsDto.IngredientsResponesDto;
import com.project.Cafe_Management_System.Service.IngredientsService.IngredientsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ingredients")
public class IngredientsController {
    private final IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping("/Get")
    public List<IngredientsResponesDto> ingredients_Get(){
        return ingredientsService.ingredients_Get();
    }
    @PostMapping("/Post")
    public IngredientsResponesDto ingredients_Insert(@RequestBody IngredientsDto ingredientsDto){
        return ingredientsService.ingredients_Post(ingredientsDto);
    }
    @PutMapping("/Update/{id}")
    public IngredientsResponesDto ingredients_Update(@PathVariable Integer id, @RequestBody IngredientsDto ingredientsDto){
        return ingredientsService.ingredients_Put(id,ingredientsDto);
    }

    @DeleteMapping("/Delete/{id}")
    public String ingredients_Delete(@PathVariable Integer id){
        return ingredientsService.ingredients_Delete(id);
    }
}
