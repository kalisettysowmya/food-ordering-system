package com.example.foodordering.service;

import com.example.foodordering.entity.MenuItem;
import com.example.foodordering.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {


    private final MenuRepository repository;


    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }


    public MenuItem save(MenuItem item) {

        return repository.save(item);
    }


    public List<MenuItem> getAll() {

        return repository.findAll();
    }


    public List<MenuItem> getByRestaurant(Long restaurantId) {

        return repository.findByRestaurantId(restaurantId);
    }


    public void delete(Long id) {

        repository.deleteById(id);
    }

}