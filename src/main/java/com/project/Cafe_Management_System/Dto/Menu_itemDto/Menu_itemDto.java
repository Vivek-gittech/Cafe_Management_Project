package com.project.Cafe_Management_System.Dto.Menu_itemDto;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Menu_itemDto {
    private int item_id;
    @Column(nullable = false)
    private String item_name;

    @Column(nullable = false)
    private Integer category_id;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stock_quantity;

    @Column(nullable = false)
    private Boolean isAvailable=true;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime update_at;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(Integer stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at() {
        this.created_at = LocalDateTime.now();
    }

    public LocalDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDateTime update_at) {
        this.update_at = update_at;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}