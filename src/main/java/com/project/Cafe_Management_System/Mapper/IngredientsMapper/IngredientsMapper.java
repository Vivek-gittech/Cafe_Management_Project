package com.project.Cafe_Management_System.Mapper.IngredientsMapper;

import com.project.Cafe_Management_System.Dto.IngredientsDto.IngredientsDto;
import com.project.Cafe_Management_System.Dto.IngredientsDto.IngredientsResponesDto;
import com.project.Cafe_Management_System.Entity.IngredientsEntity.Ingredients;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IngredientsMapper {

    public static List<IngredientsResponesDto> to_All_Get(List<Ingredients> ingredients){
        return ingredients.stream().map(IngredientsMapper::to_Dto).collect(Collectors.toList());
    }

    public static Ingredients to_Entity(IngredientsDto ingredientsDto){
        Ingredients ingredients=new Ingredients();
        ingredients.setIngredient_name(ingredientsDto.getIngredient_name());
        ingredients.setStock_quantity(ingredientsDto.getStock_quantity());
        ingredients.setUnit(ingredientsDto.getUnit());
        ingredients.setReorder_level(ingredientsDto.getReorder_level());
        return ingredients;
    }
    public static IngredientsResponesDto to_Dto(Ingredients ingredients){
        IngredientsResponesDto ingredientsResponesDto=new IngredientsResponesDto();
        ingredientsResponesDto.setIngredient_id(ingredients.getIngredient_id());
        ingredientsResponesDto.setIngredient_name(ingredients.getIngredient_name());
        ingredientsResponesDto.setStock_quantity(ingredients.getStock_quantity());
        ingredientsResponesDto.setUnit(ingredients.getUnit());
        ingredientsResponesDto.setReorder_level(ingredients.getReorder_level());
        return ingredientsResponesDto;
    }
    public static void to_Put_Entity(IngredientsDto ingredientsDto,Ingredients ingredients){
        if(ingredientsDto.getIngredient_name()!=null){
            ingredients.setIngredient_name(ingredientsDto.getIngredient_name());
        }
        if(ingredientsDto.getStock_quantity()!=null){
            ingredients.setStock_quantity(ingredientsDto.getStock_quantity());
        }
        if(ingredientsDto.getUnit()!=null){
            ingredients.setUnit(ingredientsDto.getUnit());
        }
        if(ingredientsDto.getReorder_level()!=null){
            ingredients.setReorder_level(ingredientsDto.getReorder_level());
        }
    }
}
