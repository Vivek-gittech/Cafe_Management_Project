package com.project.Cafe_Management_System.Dto.PaymentsDto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class PaymentsDto {

    @Column(nullable = false)
    private int order_id;

    @Column(nullable = false)
    private String payment_method;

    @Column(nullable = false)
    private double amount_paid;

    @Column(nullable = false)
    private LocalDateTime payment_date;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public double getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(double amount_paid) {
        this.amount_paid = amount_paid;
    }

    public LocalDateTime getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDateTime payment_date) {
        this.payment_date = payment_date;
    }
}
