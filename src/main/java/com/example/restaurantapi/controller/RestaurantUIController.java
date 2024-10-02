package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.model.Geolocation;
import com.example.restaurantapi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RestaurantUIController {

    @Autowired
    private RestaurantService restaurantService;

    // Show the form to create a new restaurant
    @GetMapping("/restaurants/new")
    public String showCreateRestaurantForm(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "create"; // Returns create.html
    }

    // Handle form submission for saving a restaurant
    @PostMapping("/restaurants/save")
    public String saveRestaurant(@ModelAttribute("restaurant") Restaurant restaurant) {
        restaurant.setGeolocation(new Geolocation(restaurant.getGeolocation().getLatitude(), restaurant.getGeolocation().getLongitude()));
        restaurantService.saveRestaurant(restaurant);
        return "redirect:/restaurants"; // Redirects to the list of restaurants
    }

    // Show list of restaurants
    @GetMapping("/restaurants")
    public String showAllRestaurants(Model model) {
        model.addAttribute("restaurants", restaurantService.getAllRestaurants());
        return "list"; // Returns list.html
    }

    // Show form for editing a restaurant
    @GetMapping("/restaurants/edit/{id}")
    public String showEditRestaurantForm(@PathVariable("id") String id, Model model) {
        Restaurant restaurant = restaurantService.getRestaurantById(id).orElse(null);
        model.addAttribute("restaurant", restaurant);
        return "create"; // Reuses create.html for the edit form
    }

    // Handle form submission for updating a restaurant
    @PostMapping("/restaurants/update")
    public String updateRestaurant(@ModelAttribute("restaurant") Restaurant restaurant) {
        restaurantService.saveRestaurant(restaurant);
        return "redirect:/restaurants"; // Redirects to the list of restaurants
    }

    // Handle restaurant deletion
    @GetMapping("/restaurants/delete/{id}")
    public String deleteRestaurant(@PathVariable("id") String id) {
        restaurantService.deleteRestaurant(id);
        return "redirect:/restaurants"; // Redirects to the list of restaurants
    }
}