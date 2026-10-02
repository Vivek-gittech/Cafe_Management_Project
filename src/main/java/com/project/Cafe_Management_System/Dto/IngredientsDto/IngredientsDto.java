package com.project.Cafe_Management_System.Dto.IngredientsDto;

public class IngredientsDto {
    private Integer ingredient_id;
    private String ingredient_name;
    private Integer stock_quantity;
    private String unit;
    private Double reorder_level;

    public Integer getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Integer ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public Integer getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(Integer stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getReorder_level() {
        return reorder_level;
    }

    public void setReorder_level(Double reorder_level) {
        this.reorder_level = reorder_level;
    }
}
