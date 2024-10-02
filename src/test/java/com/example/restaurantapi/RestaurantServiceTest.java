package com.example.restaurantapi;

import com.example.restaurantapi.model.Geolocation;
import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RestaurantServiceTest {

    @InjectMocks
    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    private Restaurant restaurant;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        restaurant = new Restaurant("1", "Test Restaurant", "123 Main St", new Geolocation(40.7128, -74.0060));
    }

    @Test
    public void testCreateRestaurant() {
        when(restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant);
        Restaurant created = restaurantService.saveRestaurant(restaurant);
        assertEquals("Test Restaurant", created.getName());
        verify(restaurantRepository, times(1)).save(restaurant);
    }

    @Test
    public void testGetRestaurantById() {
        when(restaurantRepository.findById("1")).thenReturn(Optional.of(restaurant));

        // Extract the value from the Optional
        Optional<Restaurant> found = restaurantService.getRestaurantById("1");

        // Ensure the value is present and assert the restaurant's name
        assertTrue(found.isPresent());
        assertEquals("Test Restaurant", found.get().getName());
        verify(restaurantRepository, times(1)).findById("1");
    }

    @Test
    public void testGetRestaurantByIdNotFound() {
        when(restaurantRepository.findById("2")).thenReturn(Optional.empty());

        Optional<Restaurant> found = restaurantService.getRestaurantById("2");

        assertTrue(found.isEmpty());
        verify(restaurantRepository, times(1)).findById("2");
    }
}
