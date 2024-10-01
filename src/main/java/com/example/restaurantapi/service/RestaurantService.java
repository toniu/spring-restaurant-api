package com.example.restaurantapi.service;

import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // Get all restaurants
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    // Get restaurant by ID
    public Optional<Restaurant> getRestaurantById(String id) {
        return restaurantRepository.findById(id);
    }

    // Create or update restaurant
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // Delete restaurant by ID
    public void deleteRestaurant(String id) {
        restaurantRepository.deleteById(id);
    }
}
