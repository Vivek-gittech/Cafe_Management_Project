package com.project.Cafe_Management_System.Dto.OrderDto;

import jakarta.persistence.Column;

public class OrderPatchDto {
    @Column(nullable = false)
    private Integer order_id;

    @Column(nullable = false)
    private String order_status;

    @Column(nullable = false)
    private Integer waiter_id;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Integer getWaiter_id() {
        return waiter_id;
    }

    public void setWaiter_id(Integer waiter_id) {
        this.waiter_id = waiter_id;
    }
}
