package com.project.Cafe_Management_System.Dto.TokenDto;

public class TokenResponesDto {
    private int order_id;
    private int token_number;
    private boolean is_called;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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
