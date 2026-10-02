package com.project.Cafe_Management_System.Dto.OrderDto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;



public class OrderDto {

    @Column(nullable = false)
    private Integer order_id;

    @Column(nullable = false)
    private Integer customer_id;

    @Column(nullable = false)
    private Integer waiter_id=0;

    @Column(nullable = false)
    private Integer table_number;

    @Column(nullable = false)
    private String order_status="Pending";

    @Column(nullable = false)
    private Double total_amount;

    @Column(nullable = false)
    private LocalDateTime create_at;

    @Column(nullable = false)
    private LocalDateTime update_at;


    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getWaiter_id() {
        return waiter_id;
    }

    public void setWaiter_id(Integer waiter_id) {
        this.waiter_id = waiter_id;
    }

    public void setTable_number(Integer table_number) {
        this.table_number = table_number;
    }

    public Integer getTable_number() {
        return table_number;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public LocalDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDateTime update_at) {
        this.update_at = update_at;
    }
}