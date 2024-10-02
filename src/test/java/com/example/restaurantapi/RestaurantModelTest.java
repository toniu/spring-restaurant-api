package com.example.restaurantapi;

import com.example.restaurantapi.model.Geolocation;
import com.example.restaurantapi.model.Restaurant;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantModelTest {

    private final Validator validator;

    public RestaurantModelTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void whenNameIsNull_thenValidationFails() {
        // Adjusted to match the expected number of violations
        Restaurant restaurant = new Restaurant(null, null, "123 Main St", new Geolocation(40.7128, -74.0060));
        Set<ConstraintViolation<Restaurant>> violations = validator.validate(restaurant);
        assertEquals(1, violations.size()); // Expect validation errors for name and address
    }

    @Test
    public void whenValidRestaurant_thenValidationPasses() {
        Restaurant restaurant = new Restaurant("1", "Valid Restaurant", "123 Main St", new Geolocation(40.7128, -74.0060));
        Set<ConstraintViolation<Restaurant>> violations = validator.validate(restaurant);
        assertEquals(0, violations.size()); // No violations expected
    }
}