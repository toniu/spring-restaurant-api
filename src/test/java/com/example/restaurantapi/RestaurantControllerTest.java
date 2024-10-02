package com.example.restaurantapi;

import com.example.restaurantapi.controller.RestaurantController;
import com.example.restaurantapi.model.Geolocation;
import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // Correctly mocking RestaurantService for injection
    private RestaurantService restaurantService;

    @Test
    public void testCreateRestaurant() throws Exception {
        Restaurant restaurant = new Restaurant("1", "Test Restaurant", "123 Main St", new Geolocation(40.7128, -74.0060));

        // Mock the service's saveRestaurant method
        when(restaurantService.saveRestaurant(any(Restaurant.class))).thenReturn(restaurant);

        // Perform the POST request
        mockMvc.perform(post("/api/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Test Restaurant\",\"address\":\"123 Main St\",\"geolocation\":{\"latitude\":40.7128,\"longitude\":-74.0060}}"))
                .andExpect(status().isCreated()); // Check for the correct response status
    }
}
