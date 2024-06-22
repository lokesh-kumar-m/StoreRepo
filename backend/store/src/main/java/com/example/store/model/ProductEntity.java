package com.example.store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int numbers;
    private float price;
    public ProductEntity() {
    }
    public ProductEntity(int id, String name, int numbers, float price) {
        this.id = id;
        this.name = name;
        this.numbers = numbers;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumbers() {
        return numbers;
    }
    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    
}
