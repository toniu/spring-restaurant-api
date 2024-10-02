package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.model.Geolocation;
import com.example.restaurantapi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestaurantUIController {

    @Autowired
    private RestaurantService restaurantService;

    // 1. Display all restaurants
    @GetMapping("/restaurants")
    public String showAllRestaurants(Model model) {
        model.addAttribute("restaurants", restaurantService.getAllRestaurants());
        return "restaurant-list"; // returns restaurant-list.html
    }

    // 2. Show form for creating a new restaurant or editing an existing one
    @GetMapping({"/restaurants/form", "/restaurants/form/{id}"})
    public String showRestaurantForm(@PathVariable(required = false) String id, Model model) {
        Restaurant restaurant = id != null ? restaurantService.getRestaurantById(id).orElse(new Restaurant()) : new Restaurant();
        model.addAttribute("restaurant", restaurant);
        return "restaurant-form"; // returns restaurant-form.html
    }

    // 3. Handle saving (creating or updating) a restaurant
    @PostMapping("/restaurants/save")
    public String saveRestaurant(@ModelAttribute("restaurant") Restaurant restaurant) {
        // Handle geolocation update if necessary
        if (restaurant.getGeolocation() == null) {
            restaurant.setGeolocation(new Geolocation());
        }
        restaurantService.saveRestaurant(restaurant);
        return "redirect:/restaurants"; // redirect back to restaurant list
    }

    // 4. Handle deleting a restaurant
    @PostMapping("/restaurants/delete/{id}")
    public String deleteRestaurant(@PathVariable String id) {
        restaurantService.deleteRestaurant(id);
        return "redirect:/restaurants"; // redirect back to restaurant list
    }
}