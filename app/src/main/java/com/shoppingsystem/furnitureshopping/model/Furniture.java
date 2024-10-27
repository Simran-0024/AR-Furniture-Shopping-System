package com.shoppingsystem.furnitureshopping.model; // Replace with your actual package name

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "furniture")
public class Furniture {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;
    private double price;

    // Constructor
    public Furniture(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters and Setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
