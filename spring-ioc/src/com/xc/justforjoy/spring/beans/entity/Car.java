package com.xc.justforjoy.spring.beans.entity;

/**
 * @author lxcecho
 * @since 2020/7/21
 */
public class Car {

    private String brand;

    private double price;

    /**
     * 轮胎的周长
     */
    private double tyrePerimeter;

    public double getTyrePerimeter() {
        return tyrePerimeter;
    }

    public void setTyrePerimeter(double tyrePerimeter) {
        this.tyrePerimeter = tyrePerimeter;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("setBrand...");
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Car() {
        System.out.println("Car's Constructor");
    }

    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", tyrePerimeter=" + tyrePerimeter +
                '}';
    }

    public void init2() {
        System.out.println("init...");
    }

    public void destroy() {
        System.out.println("destroy...");
    }
}
