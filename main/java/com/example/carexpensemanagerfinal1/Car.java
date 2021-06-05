package com.example.carexpensemanagerfinal1;


public class Car {
    int id;
    String carId;
    String model;
    String capacity;
    String colour;
    String ownerId;
    byte[] image;

    public Car()
    {

    }

    public Car(String carId, String model, String capacity, String colour, String ownerId, byte[] image) {
        this.carId = carId;
        this.model = model;
        this.capacity = capacity;
        this.colour = colour;
        this.ownerId = ownerId;
        this.image = image;
    }

    public Car(int id, String carId, String model, String capacity, String colour, String ownerId, byte[] image) {
        this.id = id;
        this.carId = carId;
        this.model = model;
        this.capacity = capacity;
        this.colour = colour;
        this.ownerId = ownerId;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
