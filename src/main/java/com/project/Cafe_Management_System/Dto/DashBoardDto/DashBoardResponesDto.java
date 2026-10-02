package com.project.Cafe_Management_System.Dto.DashBoardDto;

public class DashBoardResponesDto {
    private int totalCustomer;
    private double totalBill;
    private int totalPendingOrder;
    private int totalCompleteOrder;
    private int totalCancelOrder;

    public int getTotalCustomer() {
        return totalCustomer;
    }

    public void setTotalCustomer(int totalCustomer) {
        this.totalCustomer = totalCustomer;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public int getTotalPendingOrder() {
        return totalPendingOrder;
    }

    public void setTotalPendingOrder(int totalPendingOrder) {
        this.totalPendingOrder = totalPendingOrder;
    }

    public int getTotalCompleteOrder() {
        return totalCompleteOrder;
    }

    public void setTotalCompleteOrder(int totalCompleteOrder) {
        this.totalCompleteOrder = totalCompleteOrder;
    }

    public int getTotalCancelOrder() {
        return totalCancelOrder;
    }

    public void setTotalCancelOrder(int totalCancelOrder) {
        this.totalCancelOrder = totalCancelOrder;
    }
}
