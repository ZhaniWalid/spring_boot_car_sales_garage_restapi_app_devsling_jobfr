package com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.pojo_dto_classes;

import lombok.Data;

@Data // Lombock annotation => Auto generate the getter(s)/setter(s) behind the scenes & Reduce boilerplate code.
public class CarDTO {
    private String make; // Make => refers to the brand of the vehicle. Using the example of a Nissan Altima, Nissan is the make.
    private String model; // Model => refers to the specific vehicle model. Using the example of a Nissan Altima, Altima is the model.
    private int registrationDate;
    private int price;
    private String fuelType;
    // Mileage:
    //      1: It's how many kilometers the is vehicle going to run per litre of fuel
    //      2: It is also used to depict how many kilometers/ miles the vehicle has covered in its lifetime. These are the two formal usage of the term mileage.
    private int mileage;
    private String transmission;
    private String picture;

    public CarDTO() {
    }

    public CarDTO(String make, String model, int registrationDate, int price, String fuelType, int mileage, String transmission, String picture) {
        this.make = make;
        this.model = model;
        this.registrationDate = registrationDate;
        this.price = price;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.transmission = transmission;
        this.picture = picture;
    }
}
