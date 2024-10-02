package com.example.restaurantapi.model;

public class Geolocation {
    private double latitude;
    private double longitude;

    // Constructors
    public Geolocation() {}

    public Geolocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and Setters
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