package com.project.Cafe_Management_System.Mapper.Menu_itemMapper;

import com.project.Cafe_Management_System.Dto.Menu_itemDto.Menu_itemDto;
import com.project.Cafe_Management_System.Dto.Menu_itemDto.Menu_itemResponesDto;
import com.project.Cafe_Management_System.Entity.CategoryEntity.Category;
import com.project.Cafe_Management_System.Entity.Menu_itemEntity.Menu_item;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Menu_itemMapper {
    public static List<Menu_itemResponesDto> menu_Get(List<Menu_item> menu_item){
        return menu_item.stream()
                .map(Menu_itemMapper::to_Dto)
                .collect(Collectors.toList());
    }

    public static Menu_item to_Entity(Menu_itemDto menu_itemDto, Category category){
        Menu_item menu_item=new Menu_item();
        menu_item.setItem_name(menu_itemDto.getItem_name());
        menu_item.setCategory(category);
        menu_item.setPrice(menu_itemDto.getPrice());
        menu_item.setStockQuantity(menu_itemDto.getStock_quantity());
        menu_item.setAvailable(menu_itemDto.getAvailable());
        menu_item.setImageUrl(menu_itemDto.getImageUrl());
        menu_item.setCreated_at(LocalDateTime.now());
        menu_item.setUpdate_at(LocalDateTime.now());
        return menu_item;
    }
    public static Menu_itemResponesDto to_Dto(Menu_item menu_item){
        Menu_itemResponesDto menu_itemResponesDto=new Menu_itemResponesDto();
        menu_itemResponesDto.setItem_name(menu_item.getItem_name());
        menu_itemResponesDto.setPrice(menu_item.getPrice());
        menu_itemResponesDto.setStock_quantity(menu_item.getStockQuantity());
        menu_itemResponesDto.setAvailable(menu_item.Available());
        menu_itemResponesDto.setImagesUrl(menu_item.getImageUrl());
        if(menu_item.getCategory()!=null) {
            menu_itemResponesDto.setCategory_name(menu_item.getCategory().getCategory_name());
        }
        return menu_itemResponesDto;
    }
    public static void to_Put_Entity(Menu_itemDto menu_itemDto,Menu_item menu_item,Category category){
        if(menu_itemDto.getItem_name()!=null){
            menu_item.setItem_name(menu_itemDto.getItem_name());
        }
        if(menu_itemDto.getCategory_id()!=null){
            menu_item.setCategory(category);
        }
        if(menu_itemDto.getItem_name()!=null){
            menu_item.setItem_name(menu_itemDto.getItem_name());
        }
        if(menu_itemDto.getPrice()!=null){
            menu_item.setPrice(menu_itemDto.getPrice());
        }
        if(menu_itemDto.getStock_quantity()!=null){
            menu_item.setStockQuantity(menu_itemDto.getStock_quantity());
        }
        if(menu_itemDto.getAvailable()!=null){
            menu_item.setAvailable(menu_itemDto.getAvailable());
        }
        if(menu_itemDto.getImageUrl()!=null){
            menu_item.setImageUrl(menu_item.getImageUrl());
        }
            menu_item.setCreated_at(menu_item.getCreated_at());
            menu_item.setUpdate_at(LocalDateTime.now());
    }
}