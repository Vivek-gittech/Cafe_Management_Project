package com.project.Cafe_Management_System.Service.IngredientsService.IngredientsServiceIml;

import com.project.Cafe_Management_System.Dto.IngredientsDto.IngredientsDto;
import com.project.Cafe_Management_System.Dto.IngredientsDto.IngredientsResponesDto;
import com.project.Cafe_Management_System.Entity.IngredientsEntity.Ingredients;
import com.project.Cafe_Management_System.Mapper.IngredientsMapper.IngredientsMapper;
import com.project.Cafe_Management_System.Repository.IngredientsRepository.IngredientsRepository;
import com.project.Cafe_Management_System.Service.IngredientsService.IngredientsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsServiceIml implements IngredientsService {
    private final IngredientsRepository ingredientsRepository;
    private final IngredientsMapper ingredientsMapper;

    public IngredientsServiceIml(IngredientsRepository ingredientsRepository, IngredientsMapper ingredientsMapper) {
        this.ingredientsRepository = ingredientsRepository;
        this.ingredientsMapper = ingredientsMapper;
    }

    @Override
    public List<IngredientsResponesDto> ingredients_Get(){
        List<Ingredients> ingredients=ingredientsRepository.findAll();
        return IngredientsMapper.to_All_Get(ingredients);
    }
    public IngredientsResponesDto ingredients_Post(IngredientsDto ingredientsDto){
        Ingredients ingredients=IngredientsMapper.to_Entity(ingredientsDto);
        Ingredients ingredientsSaved=ingredientsRepository.save(ingredients);
        return IngredientsMapper.to_Dto(ingredientsSaved);
    }
    public IngredientsResponesDto ingredients_Put(Integer id,IngredientsDto ingredientsDto){
        Ingredients ingredients=ingredientsRepository.findById(id).orElseThrow(()->new RuntimeException("Ingredients Not Found"));
        IngredientsMapper.to_Put_Entity(ingredientsDto,ingredients);
        Ingredients ingredientsSaved=ingredientsRepository.save(ingredients);
        return IngredientsMapper.to_Dto(ingredients);
    }
    public String ingredients_Delete(Integer id){
        Ingredients ingredients=ingredientsRepository.findById(id).orElseThrow(()->new RuntimeException("Ingredients Not Found"));
        ingredientsRepository.deleteById(id);
        return id+"Delete Successfully";
    }
}
