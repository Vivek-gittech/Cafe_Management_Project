package com.project.Cafe_Management_System.Dto.Recipe_itemDto;

import jakarta.persistence.Column;

public class Recipe_itemDto {

    @Column(nullable = false)
    private Integer item_id;

    @Column(nullable = false)
    private Integer ingredient_id;

    @Column(nullable = false)
    private Integer order_id;

    @Column(nullable = false)
    private Integer order_item_id;

    @Column(nullable = false)
    private double quantity_required;



    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Integer ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(Integer order_item_id) {
        this.order_item_id = order_item_id;
    }

    public double getQuantity_required() {
        return quantity_required;
    }

    public void setQuantity_required(double quantity_required) {
        this.quantity_required = quantity_required;
    }
}
