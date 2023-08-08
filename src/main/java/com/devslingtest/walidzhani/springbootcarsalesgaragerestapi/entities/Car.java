package com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "car")
@Data // Lombock annotation => Auto generate the getter(s)/setter(s) behind the scenes & Reduce boilerplate code.
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car")
    private Integer idCar;

    @Column(name = "make")
    private String make; // Make => refers to the brand of the vehicle. Using the example of a Nissan Altima, Nissan is the make.

    @Column(name = "model")
    private String model; // Model => refers to the specific vehicle model. Using the example of a Nissan Altima, Altima is the model.

    @Column(name = "registration_date")
    private int registrationDate;

    @Column(name = "price")
    private int price;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "mileage")
    // Mileage:
    //      1: It's how many kilometers the is vehicle going to run per litre of fuel
    //      2: It is also used to depict how many kilometers/ miles the vehicle has covered in its lifetime. These are the two formal usage of the term mileage.
    private int mileage;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "picture")
    private String picture;

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", price=" + price +
                ", fuelType='" + fuelType + '\'' +
                ", mileage='" + mileage + '\'' +
                ", transmission='" + transmission + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

    // We can get rid of the Getters & Setters because the @Data Lombock annotation will do it behind the scenes
    /* public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public GarageCatalog getGarageCatalog() {
        return garageCatalog;
    }

    public void setGarageCatalog(GarageCatalog garageCatalog) {
        this.garageCatalog = garageCatalog;
    } */
}