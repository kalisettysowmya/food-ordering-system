package com.example.foodordering.repository;

import com.example.foodordering.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository 
        extends JpaRepository<Restaurant, Long> {

}
