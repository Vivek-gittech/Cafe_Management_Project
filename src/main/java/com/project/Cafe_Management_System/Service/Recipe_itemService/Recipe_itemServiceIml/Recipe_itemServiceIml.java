package com.project.Cafe_Management_System.Service.Recipe_itemService.Recipe_itemServiceIml;

import com.project.Cafe_Management_System.Dto.Recipe_itemDto.Recipe_itemDto;
import com.project.Cafe_Management_System.Dto.Recipe_itemDto.Recipe_itemResponesDto;
import com.project.Cafe_Management_System.Entity.IngredientsEntity.Ingredients;
import com.project.Cafe_Management_System.Entity.Menu_itemEntity.Menu_item;
import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import com.project.Cafe_Management_System.Entity.Order_itemEntity.Order_item;
import com.project.Cafe_Management_System.Entity.Recipe_itemEntity.Recipe_item;
import com.project.Cafe_Management_System.Mapper.Recipe_itemMapper.Recipe_itemMapper;
import com.project.Cafe_Management_System.Repository.IngredientsRepository.IngredientsRepository;
import com.project.Cafe_Management_System.Repository.Menu_itemRepository.Menu_itemRepository;
import com.project.Cafe_Management_System.Repository.OrderRepository.OrderRepository;
import com.project.Cafe_Management_System.Repository.Order_itemRepository.Order_itemRepository;
import com.project.Cafe_Management_System.Repository.Recipe_itemRepository.Recipe_itemRepository;
import com.project.Cafe_Management_System.Service.Recipe_itemService.Recipe_itemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Recipe_itemServiceIml implements Recipe_itemService {
    private final Recipe_itemRepository recipe_itemRepository;
    private final Recipe_itemMapper recipe_itemMapper;
    private final OrderRepository orderRepository;
    private final Menu_itemRepository menu_itemRepository;
    private final IngredientsRepository ingredientsRepository;
    private final Order_itemRepository order_itemRepository;

    public Recipe_itemServiceIml(Recipe_itemRepository recipe_itemRepository, Recipe_itemMapper recipe_itemMapper, OrderRepository orderRepository, Menu_itemRepository menu_itemRepository, IngredientsRepository ingredientsRepository, Order_itemRepository order_itemRepository) {
        this.recipe_itemRepository = recipe_itemRepository;
        this.recipe_itemMapper = recipe_itemMapper;
        this.orderRepository = orderRepository;
        this.menu_itemRepository = menu_itemRepository;
        this.ingredientsRepository = ingredientsRepository;
        this.order_itemRepository = order_itemRepository;
    }

    @Override
    public List<Recipe_itemResponesDto> recipe_Get(){
        List<Recipe_item> recipe_item=recipe_itemRepository.findAll();
        return Recipe_itemMapper.to_All_Dto(recipe_item);
    }
    public Recipe_itemResponesDto recipe_Post(Recipe_itemDto recipe_itemDto) {
        Order_item order_item = order_itemRepository.findById(recipe_itemDto.getOrder_item_id()).orElseThrow(() -> new RuntimeException("Order_item Not Found"));
        Order order = orderRepository.findById(recipe_itemDto.getOrder_id()).orElseThrow(() -> new RuntimeException("Order Not Found"));
        Menu_item menu_item = menu_itemRepository.findById(recipe_itemDto.getItem_id()).orElseThrow(() -> new RuntimeException("Menu Not Found"));
        Ingredients ingredients = ingredientsRepository.findById(recipe_itemDto.getIngredient_id()).orElseThrow(() -> new RuntimeException("Ingredients Not Found"));

        double total_bill = calcultion(order_item);
        Recipe_item recipe_item = Recipe_itemMapper.to_Entity(total_bill,order_item, menu_item, ingredients);
        Recipe_item recipe_itemSaved = recipe_itemRepository.save(recipe_item);

        recipe_itemSaved.setTotal_bill(total_bill);
        recipe_itemSaved.setQuantity_required(order_item.getQuantity());
        return Recipe_itemMapper.to_Dto(recipe_itemSaved);
    }
    public Recipe_itemResponesDto recipe_Put(Integer id,Recipe_itemDto recipe_itemDto){
        Order_item order_item = order_itemRepository.findById(recipe_itemDto.getOrder_item_id()).orElseThrow(() -> new RuntimeException("Order_item Not Found"));
        Order order = orderRepository.findById(recipe_itemDto.getOrder_id()).orElseThrow(() -> new RuntimeException("Order Not Found"));
        Menu_item menu_item = menu_itemRepository.findById(recipe_itemDto.getItem_id()).orElseThrow(() -> new RuntimeException("Menu Not Found"));
        Ingredients ingredients = ingredientsRepository.findById(recipe_itemDto.getIngredient_id()).orElseThrow(() -> new RuntimeException("Ingredients Not Found"));
        Recipe_item recipe_item=recipe_itemRepository.findById(id).orElseThrow(()->new RuntimeException("Recipe_item Not Found"));

        double total_bill = calcultion(order_item);
        Recipe_itemMapper.to_Put_Entity(total_bill,recipe_item,recipe_itemDto,order_item,menu_item,ingredients);
        Recipe_item recipe_itemSaved=recipe_itemRepository.save(recipe_item);
        return Recipe_itemMapper.to_Dto(recipe_itemSaved);
    }

    public String recipe_Delete(Integer id){
        Recipe_item recipe_item=recipe_itemRepository.findById(id).orElseThrow(()->new RuntimeException("Recipe_item Not Found"));
        recipe_itemRepository.deleteById(id);
        return id+" Recipe_item Record Delete Successfully";
    }

    public double calcultion(Order_item order_item) {
        double total_bill = order_item.getQuantity() * order_item.getSubtotalPrice();
        return total_bill;
    }
}