package com.project.Cafe_Management_System.Entity.Recipe_itemEntity;

import com.project.Cafe_Management_System.Entity.IngredientsEntity.Ingredients;
import com.project.Cafe_Management_System.Entity.Menu_itemEntity.Menu_item;
import jakarta.persistence.*;

@Entity
@Table(name = "Recipe_Items")
public class Recipe_item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipe_item_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id",nullable = false)
    private Menu_item menu_item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id",nullable = false)
    private Ingredients ingredients;

    @Column(nullable = false)
    private double quantity_required;

    @Column(nullable = false)
    private double total_bill;

    public int getRecipe_item_id() {
        return recipe_item_id;
    }

    public void setRecipe_item_id(int recipe_item_id) {
        this.recipe_item_id = recipe_item_id;
    }

    public Menu_item getMenu_item() {
        return menu_item;
    }

    public void setMenu_item(Menu_item menu_item) {
        this.menu_item = menu_item;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public double getQuantity_required() {
        return quantity_required;
    }

    public void setQuantity_required(double quantity_required) {
        this.quantity_required = quantity_required;
    }

    public double getTotal_bill() {
        return total_bill;
    }

    public void setTotal_bill(double total_bill) {
        this.total_bill = total_bill;
    }
}