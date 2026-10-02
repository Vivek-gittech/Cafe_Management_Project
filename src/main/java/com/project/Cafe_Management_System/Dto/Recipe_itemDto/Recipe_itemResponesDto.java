package com.project.Cafe_Management_System.Dto.Recipe_itemDto;


public class Recipe_itemResponesDto {

    private String item_name;
    private Double total_amount;
    private Double quantity;
    private Double quantity_required;

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }


    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getQuantity_required() {
        return quantity_required;
    }

    public void setQuantity_required(Double quantity_required) {
        this.quantity_required = quantity_required;
    }
}
