package com.example.foodordering.controller;

import com.example.foodordering.entity.Restaurant;
import com.example.foodordering.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }


    @PostMapping
    public Restaurant create(
            @RequestBody Restaurant restaurant) {

        return service.save(restaurant);
    }


    @GetMapping
    public List<Restaurant> getAll() {

        return service.getAll();
    }


    @GetMapping("/{id}")
    public Restaurant getById(
            @PathVariable Long id) {

        return service.getById(id);
    }


    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id) {

        service.delete(id);

        return "Restaurant deleted";
    }
}