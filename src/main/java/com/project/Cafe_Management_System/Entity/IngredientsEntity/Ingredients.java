package com.project.Cafe_Management_System.Entity.IngredientsEntity;

import jakarta.persistence.*;

@Entity
@Table(name="Ingredients")
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredient_id;
    private String ingredient_name;
    private int stock_quantity;
    private String unit;
    private double reorder_level;

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getReorder_level() {
        return reorder_level;
    }

    public void setReorder_level(double reorder_level) {
        this.reorder_level = reorder_level;
    }
}