package com.xzy.spring.interfaces.factoryBean;

public class Car {

    private String brand;
    private int maxSpeed;
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{brand=" + brand + ", maxSpeed=" + maxSpeed + ", price=" + price + "}";
    }
}
