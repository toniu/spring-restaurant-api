package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // Get all restaurants
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    // Get restaurant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable String id) {
        return restaurantService.getRestaurantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new restaurant
    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@Validated @RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantService.saveRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRestaurant);
    }

    // Update an existing restaurant
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable String id, @Validated @RequestBody Restaurant restaurant) {
        restaurant.setId(id);
        Restaurant updatedRestaurant = restaurantService.saveRestaurant(restaurant);
        return ResponseEntity.ok(updatedRestaurant);
    }

    // Delete a restaurant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable String id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
}
