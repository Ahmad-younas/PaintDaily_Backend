package com.example.backend.entity;


import jakarta.persistence.*;

@Entity
public class RegisterUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String userName;
    private String pendingOrder;
    private String completedOrder;
    private String purchased;
    private String cancelledOrders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPendingOrder() {
        return pendingOrder;
    }

    public void setPendingOrder(String pendingOrder) {
        this.pendingOrder = pendingOrder;
    }

    public String getCompletedOrder() {
        return completedOrder;
    }

    public void setCompletedOrder(String completedOrder) {
        this.completedOrder = completedOrder;
    }

    public String getPurchased() {
        return purchased;
    }

    public void setPurchased(String purchased) {
        this.purchased = purchased;
    }

    public String getCancelledOrders() {
        return cancelledOrders;
    }

    public void setCancelledOrders(String cancelledOrders) {
        this.cancelledOrders = cancelledOrders;
    }
}
