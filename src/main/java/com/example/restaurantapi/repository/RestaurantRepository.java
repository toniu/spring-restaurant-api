package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    // You can define custom query methods here if needed
}
