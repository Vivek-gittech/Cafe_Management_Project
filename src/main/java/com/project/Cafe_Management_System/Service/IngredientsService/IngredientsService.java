package com.project.Cafe_Management_System.Service.IngredientsService;

import com.project.Cafe_Management_System.Dto.IngredientsDto.IngredientsDto;
import com.project.Cafe_Management_System.Dto.IngredientsDto.IngredientsResponesDto;

import java.util.List;

public interface IngredientsService {

    public List<IngredientsResponesDto> ingredients_Get();
    public IngredientsResponesDto ingredients_Post(IngredientsDto ingredientsDto);
    public IngredientsResponesDto ingredients_Put(Integer id,IngredientsDto ingredientsDto);
    public String ingredients_Delete(Integer id);
}
