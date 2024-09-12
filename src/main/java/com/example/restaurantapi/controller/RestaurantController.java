package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/restaurant-api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable String id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/location")
    public Restaurant getRestaurantLocation(@PathVariable String id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable String id, @RequestBody Restaurant restaurant) {
        if (restaurantRepository.existsById(id)) {
            restaurant.setId(id);
            return restaurantRepository.save(restaurant);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable String id) {
        restaurantRepository.deleteById(id);
    }
}