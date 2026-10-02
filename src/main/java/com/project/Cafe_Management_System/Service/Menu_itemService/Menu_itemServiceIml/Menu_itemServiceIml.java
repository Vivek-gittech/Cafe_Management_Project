package com.project.Cafe_Management_System.Service.Menu_itemService.Menu_itemServiceIml;

import com.project.Cafe_Management_System.Dto.Menu_itemDto.Menu_itemDto;
import com.project.Cafe_Management_System.Dto.Menu_itemDto.Menu_itemResponesDto;
import com.project.Cafe_Management_System.Entity.CategoryEntity.Category;
import com.project.Cafe_Management_System.Entity.Menu_itemEntity.Menu_item;
import com.project.Cafe_Management_System.Mapper.Menu_itemMapper.Menu_itemMapper;
import com.project.Cafe_Management_System.Repository.CategoryRepository.CategoryRepository;
import com.project.Cafe_Management_System.Repository.Menu_itemRepository.Menu_itemRepository;
import com.project.Cafe_Management_System.Service.Menu_itemService.Menu_itemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Menu_itemServiceIml implements Menu_itemService {

    private final Menu_itemRepository menu_itemRepository;
    private final Menu_itemMapper menu_itemMapper;
    private final CategoryRepository categoryRepository;

    public Menu_itemServiceIml(Menu_itemRepository menu_itemRepository, Menu_itemMapper menu_itemMapper, CategoryRepository categoryRepository) {
        this.menu_itemRepository = menu_itemRepository;
        this.menu_itemMapper = menu_itemMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Menu_itemResponesDto> menu_Get(){
        List<Menu_item> menu_item=menu_itemRepository.findAll();
        return Menu_itemMapper.menu_Get(menu_item);
    }
    public Menu_itemResponesDto menu_Post(Menu_itemDto menu_itemDto){
        Category category=categoryRepository.findById(menu_itemDto.getCategory_id()).orElseThrow(()->new RuntimeException("Category Not Find"));
        Menu_item menu_item=Menu_itemMapper.to_Entity(menu_itemDto,category);
        Menu_item menu_saved=menu_itemRepository.save(menu_item);
        return Menu_itemMapper.to_Dto(menu_saved);
    }
    public String menu_Put(Integer id,Menu_itemDto menu_itemDto){
        Category category=categoryRepository.findById(menu_itemDto.getCategory_id()).orElseThrow(()->new RuntimeException("Category Not Found"));
        Menu_item menu_item=menu_itemRepository.findById(id).orElseThrow(()->new RuntimeException("Menu Not Found"));
        Menu_itemMapper.to_Put_Entity(menu_itemDto,menu_item,category);
        menu_itemRepository.save(menu_item);
        return id+" Menu Updated Successfully";
    }
    public String menu_Delete(Integer id){
        if(menu_itemRepository.existsById(id)){
            menu_itemRepository.deleteById(id);
            return id+" Menu Delete Successfully";
        }
        return "Menu Not Found";
    }
}