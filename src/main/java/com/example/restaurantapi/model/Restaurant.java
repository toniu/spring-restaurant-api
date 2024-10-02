package com.example.restaurantapi.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "restaurants")
public class Restaurant {

    @Id
    private String id;

    @NotNull(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Address is required")
    @Size(min = 10, max = 255, message = "Address should be between 10 and 255 characters")
    private String address;

    private Geolocation geolocation;

    // Constructors
    public Restaurant() {}

    public Restaurant(String id, String name, String address, Geolocation geolocation) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.geolocation = geolocation;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", geolocation=" + geolocation +
                '}';
    }
}