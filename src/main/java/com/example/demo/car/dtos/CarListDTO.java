package com.example.demo.car.dtos;

public class CarListDTO {
    private final long id;
    private final String make;
    private final String model;
    private final double avgRating;

    public CarListDTO(long id, String make, String model, double avgRating) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.avgRating = avgRating;
    }

    public long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getAvgRating() {
        return avgRating;
    }
}
