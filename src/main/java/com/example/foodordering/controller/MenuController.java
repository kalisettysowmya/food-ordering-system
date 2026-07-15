package com.example.foodordering.controller;


import com.example.foodordering.entity.MenuItem;
import com.example.foodordering.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/menu")
public class MenuController {


    private final MenuService service;


    public MenuController(MenuService service) {

        this.service = service;
    }


    @PostMapping
    public MenuItem create(
            @RequestBody MenuItem item) {

        return service.save(item);
    }


    @GetMapping
    public List<MenuItem> getAll(){

        return service.getAll();
    }


    @GetMapping("/restaurant/{id}")
    public List<MenuItem> getByRestaurant(
            @PathVariable Long id){

        return service.getByRestaurant(id);
    }


    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id){

        service.delete(id);

        return "Menu item deleted";
    }

}