package com.project.Cafe_Management_System.Mapper.Recipe_itemMapper;

import com.project.Cafe_Management_System.Dto.Recipe_itemDto.Recipe_itemDto;
import com.project.Cafe_Management_System.Dto.Recipe_itemDto.Recipe_itemResponesDto;
import com.project.Cafe_Management_System.Entity.IngredientsEntity.Ingredients;
import com.project.Cafe_Management_System.Entity.Menu_itemEntity.Menu_item;
import com.project.Cafe_Management_System.Entity.Order_itemEntity.Order_item;
import com.project.Cafe_Management_System.Entity.Recipe_itemEntity.Recipe_item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Recipe_itemMapper {

    public static Recipe_item to_Entity(double total_bill,Order_item order_item,Menu_item menu_item, Ingredients ingredients){
        Recipe_item recipe_item=new Recipe_item();
        recipe_item.setMenu_item( menu_item);
        recipe_item.setIngredients(ingredients);
        recipe_item.setTotal_bill(total_bill);
        recipe_item.setQuantity_required(order_item.getQuantity());
        return recipe_item;
    }
    public static Recipe_itemResponesDto to_Dto(Recipe_item recipe_item){
        Recipe_itemResponesDto recipe_itemResponesDto=new Recipe_itemResponesDto();
        recipe_itemResponesDto.setItem_name(recipe_item.getMenu_item().getItem_name());
        recipe_itemResponesDto.setTotal_amount(recipe_item.getTotal_bill());
        recipe_itemResponesDto.setQuantity_required(recipe_item.getQuantity_required());
        return recipe_itemResponesDto;
    }
    public static List<Recipe_itemResponesDto> to_All_Dto(List<Recipe_item> recipe_item){
        return recipe_item.stream()
                .map(Recipe_itemMapper :: to_Dto)
                .collect(Collectors.toList());
    }
    public static void to_Put_Entity(double total_bill,Recipe_item recipe_item,Recipe_itemDto recipe_itemDto,Order_item order_item,Menu_item menu_item,Ingredients ingredients){
        if(recipe_itemDto.getItem_id()!=null){
            recipe_item.setMenu_item(menu_item);
        }
        if(recipe_itemDto.getOrder_item_id()!=null){
            recipe_item.setTotal_bill(total_bill);
        }
        if(recipe_itemDto.getIngredient_id()!=null){
            recipe_item.setIngredients(ingredients);
        }
        if(recipe_itemDto.getOrder_item_id()!=null){
            recipe_item.setQuantity_required(order_item.getQuantity());
        }
    }
}
