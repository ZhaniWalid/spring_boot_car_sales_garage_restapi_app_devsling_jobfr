package com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.controllers;

import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.entities.Car;
import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.entities.GarageCatalog;
import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.pojo_dto_classes.CarDTO;
import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.services.CarServ.CarService;
import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.services.GarageCatalogServ.GarageCatalogService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-sales-garage-restapi")
@OpenAPIDefinition(
        info = @Info (
                title = "Car Sales Garage - SPRING BOOT REST API for DEVSLING job test - France",
                version = "1.0",
                description = "Walid Zhani REST API",
                contact = @Contact(
                        url = "https://www.linkedin.com/in/walid-zhani-54705612a/",
                        name = "Walid Zhani",
                        email = "walid.zhani@esprit.tn, walid.zhani24@gmail.com"
                )
        )
)
public class CarSalesGarageController {
    @Autowired
    GarageCatalogService garageCatalogService;

    @Autowired
    CarService carService;

    public CarSalesGarageController(GarageCatalogService garageCatalogService, CarService carService) {
        this.garageCatalogService = garageCatalogService;
        this.carService = carService;
    }

    @GetMapping("/garage-catalogs")
    @Operation(
            summary = "Get list of Garage Catalogs",
            description = "GET list of Garage Catalogs from the H2 database"
    )
    public List<GarageCatalog> getAllGarageCatalogs() {
        return garageCatalogService.findAllGarageCatalogs();
    }

    @GetMapping("/cars")
    @Operation(
            summary = "Get list of Cars",
            description = "GET list of Cars from the H2 database"
    )
    public List<Car> getAllCars() {
        return carService.findAllCars();
    }

    @PostMapping("/cars/createNewCar")
    @Operation(
            summary = "Add / Create new Car to the Catalog of Cars",
            description = "Add / Create new Car to the Catalog of Cars and Save it to the H2 database"
    )
    public String createNewCar(@RequestBody CarDTO carRequestDTO) {
        // Example of how the post the "RequestBody" as "raw JSON" data from the POSTMAN Client for example
        /*
            {
                "make": "Lamborghini",
                "model": "Gallardo",
                "registrationDate": 2020,
                "price": 175000,
                "fuelType": "HYBRID",
                "mileage": 288789,
                "transmission": "AUTOMATIC",
                "picture": "resources/static/images/4__2020-Lamborghini-Gallardo.jpg"
            }
        */

        return carService.addNewCar(carRequestDTO);
    }

    @PutMapping("/cars/updatePicUrlExistingCar/{id-car}")
    @Operation(
            summary = "Update the picture url of an existing Car from the Catalog of Cars",
            description = "Update the picture url of an existing Car from the Catalog of Cars and Save it to the H2 database"
    )
    public String updatePicUrlExistingCar(@PathVariable("id-car") Integer idCarParam, @RequestBody CarDTO carRequestDTO) {
        // Example of how the post the "RequestBody" as "raw JSON" data from the POSTMAN Client for example
        /*
            {
                "picture": "resources/static/images/6__2020-Dodge-Challenger-updated.jpg"
            }
        */
        String newPictureUrl = "";

        if (carRequestDTO != null)
            newPictureUrl = carRequestDTO.getPicture();

        return carService.updateCarPicture(idCarParam, newPictureUrl);
    }

    @GetMapping("/cars/{fuel-type}/{max-price}")
    @Operation(
            summary = "Get list of Cars with filter",
            description = "GET list of Cars by FUEL TYPE and less than a maximum PRICE from the H2 database"
    )
    public List<Car> getAllCarsByFuelTypeAndMaxPrice(@PathVariable("fuel-type") String fuelTypeParam,
         @PathVariable("max-price") String maxPriceParam) {

        return carService.displayAllCarsByFuelTypeAndMaxPrice(fuelTypeParam, maxPriceParam);
    }

    @GetMapping("/cars/all-makes")
    @Operation(
            summary = "Get list of all Car Makes",
            description = "GET list of all Car Makes from the H2 database"
    )
    public List<String> getAllMakesAvailableInCatalog() {
        return carService.displaysAllMakesAvailableInCatalog();
    }
}