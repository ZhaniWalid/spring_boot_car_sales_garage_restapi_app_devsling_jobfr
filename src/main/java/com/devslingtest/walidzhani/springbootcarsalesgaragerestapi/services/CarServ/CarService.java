package com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.services.CarServ;

import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.entities.Car;
import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.pojo_dto_classes.CarDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarService {
    List<Car> findAllCars();
    String addNewCar(CarDTO carDTO);
    String updateCarPicture(Integer idOfCar, String pictureUrl);
    List<Car> displayAllCarsByFuelTypeAndMaxPrice(String fuelType, String maxPrice);
    List<String> displaysAllMakesAvailableInCatalog();
}
