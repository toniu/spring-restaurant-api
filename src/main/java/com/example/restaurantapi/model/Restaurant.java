package com.example.restaurantapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Assuming Geolocation is another model in your project
// You need to define this or import if using an external library
class Geolocation {
    private double latitude;
    private double longitude;

    public Geolocation() {
    }

    public Geolocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Geolocation{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

@Document(collection = "restaurants")
public class Restaurant {

    @Id
    private String id;
    private String name;
    private String address;
    private Geolocation geolocation;

    // Constructors
    public Restaurant() {
    }

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
