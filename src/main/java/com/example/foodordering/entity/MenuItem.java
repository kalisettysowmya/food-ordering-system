package com.example.foodordering.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    private String description;

    private double price;

    private boolean available;


    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


    public MenuItem() {
    }


    public MenuItem(String itemName,
                    String description,
                    double price,
                    boolean available,
                    Restaurant restaurant) {

        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.available = available;
        this.restaurant = restaurant;
    }


    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }


    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}