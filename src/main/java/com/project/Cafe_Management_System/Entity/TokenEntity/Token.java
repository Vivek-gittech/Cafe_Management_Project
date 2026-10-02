package com.project.Cafe_Management_System.Entity.TokenEntity;

import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import jakarta.persistence.*;


@Entity
@Table(name="Tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int token_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Order_id",nullable = false)
    private Order order;

    @Column(nullable = false)
    private int token_number;

    @Column(nullable = false)
    private boolean is_called;

    public int getToken_id() {
        return token_id;
    }

    public void setToken_id(int token_id) {
        this.token_id = token_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getToken_number() {
        return token_number;
    }

    public void setToken_number(int token_number) {
        this.token_number = token_number;
    }

    public boolean isIs_called() {
        return is_called;
    }

    public void setIs_called(boolean is_called) {
        this.is_called = is_called;
    }
}
