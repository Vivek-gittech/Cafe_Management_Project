package com.project.Cafe_Management_System.Entity.Order_itemEntity;

import com.project.Cafe_Management_System.Entity.Menu_itemEntity.Menu_item;
import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import jakarta.persistence.*;


@Entity
@Table(name="Order_Items")
public class Order_item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_item_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id",nullable = false)
    private Menu_item menu_item;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double subtotalPrice;

    public int getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(int order_item_id) {
        this.order_item_id = order_item_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Menu_item getMenu_item() {
        return menu_item;
    }

    public void setMenu_item(Menu_item menu_item) {
        this.menu_item = menu_item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotalPrice() {
        return subtotalPrice;
    }

    public void setSubtotalPrice(double subtotalPrice) {
        this.subtotalPrice = subtotalPrice;
    }
}