package com.example.store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OrdersEntity {
    @Id
    @GeneratedValue
    private int userId;
    private String userName;
    private String productName;
    private float cost;
    private int quantity;
    public OrdersEntity() {
    }
    public OrdersEntity(int userId, String userName, String productName, float cost, int quantity) {
        this.userId = userId;
        this.userName = userName;
        this.productName = productName;
        this.cost = cost;
        this.quantity = quantity;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
