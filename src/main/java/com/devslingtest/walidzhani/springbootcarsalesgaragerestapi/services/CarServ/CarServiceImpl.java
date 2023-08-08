package com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.services.CarServ;

import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.dao.CarRepository;
import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.entities.Car;
import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.pojo_dto_classes.CarDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("CarService")
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {
    private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    CarRepository carRepository;

    @PersistenceContext
    EntityManager entityManager;

    public CarServiceImpl() {
    }

    @Override
    public List<Car> findAllCars() {
        logger.info("findAllCars(): "+ carRepository.findAll());
        return carRepository.findAll();
    }

    @Override
    @Transactional
    public String addNewCar(CarDTO carDTORequest) {
        String msgRes = "";

        // Mapping between "carDTO" object & "Car" Entity Object
        Car carRequestToAdd = new Car();

        // There is no Need to add manually a new ID, because the "CarRepository" (who extends "JpaRepository") will generate a new ID auto
        // because we have the "ID" in the "Car" Entity, that will be "auto-generated" in the "save" method below
        /*  @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "id_car")
            private Integer idCar;
        */
        // int lastId = findAllCars().size();
        // int newId = lastId + 1;
        // carRequestToAdd.setIdCar(newId);
        carRequestToAdd.setMake(carDTORequest.getMake());
        carRequestToAdd.setModel(carDTORequest.getModel());
        carRequestToAdd.setRegistrationDate(carDTORequest.getRegistrationDate());
        carRequestToAdd.setPrice(carDTORequest.getPrice());
        carRequestToAdd.setFuelType(carDTORequest.getFuelType());
        carRequestToAdd.setMileage(carDTORequest.getMileage());
        carRequestToAdd.setTransmission(carDTORequest.getTransmission());
        carRequestToAdd.setPicture(carDTORequest.getPicture());

        if (carRequestToAdd.getRegistrationDate() >= 2015) {
            // Add the mapped "Smartphone" Entity Object
            carRepository.save(carRequestToAdd);

            //logger.info("createNewCar() @ lastId: "+ lastId+ " - newId: "+ newId);
            msgRes = "The Car : -- "+ carRequestToAdd.getMake()+ " "+ carRequestToAdd.getModel()+ " --, has been registered successfully.";
        } else {
            msgRes = "The Car : -- "+ carRequestToAdd.getMake()+ " "+ carRequestToAdd.getModel()+
                " --, has been failed to register because the registration date is < 2015.";
        }
        logger.info("addNewCar() @ msgRes: "+ msgRes);

        return msgRes;
    }

    @Override
    @Transactional
    public String updateCarPicture(Integer idOfCar, String pictureUrl) {
        String msgRes = "";
        Optional<Car> carToUpdate = carRepository.findById(idOfCar);

        if (carToUpdate.isPresent()) {
            Car car = carToUpdate.get();
            car.setPicture(pictureUrl);
            carRepository.save(car);

            logger.info("The Car you are searching for is PRESENT / EXIST.");
            msgRes = "The Car : -- "+ car.getMake()+ " "+ car.getModel()+ " --, it's -- picture url -- has been updated successfully.";

        } else
            msgRes = "The Car you are searching for is not PRESENT / DON'T EXIST. The -- picture url -- has been failed to update.";

        logger.info(msgRes);
        return msgRes;
    }

    @Override
    public List<Car> displayAllCarsByFuelTypeAndMaxPrice(String fuelType, String maxPrice) {
        TypedQuery typedQuery = entityManager
                .createQuery("SELECT c FROM Car c WHERE c.fuelType = :param1 AND c.price <= :param2", Car.class);

        // SELECT * FROM CAR WHERE fuel_type = 'HYBRID' AND price <= 17500;

        typedQuery.setParameter("param1", fuelType.toUpperCase());
        typedQuery.setParameter("param2", maxPrice);

        logger.info("displayAllCarsByFuelTypeAndMaxPrice() @ typedQuery - Param1: "+ typedQuery.getParameterValue("param1").toString()
            + " - Param2: "+ typedQuery.getParameterValue("param2").toString());

        entityManager.close();

        return typedQuery.getResultList();
    }

    @Override
    public List<String> displaysAllMakesAvailableInCatalog() {
        List<String> allMakes = new ArrayList<>();
        List<Car> allCars = carRepository.findAll();

        for (Car car : allCars)
            allMakes.add(car.getMake());

        // All Cars "Makes" without duplicates using Java 8 Lambda expression
        List<String> allMakesWithoutDuplicates = allMakes.stream().distinct().toList();

        logger.info("displaysAllMakesAvailableInCatalog() @ allMakes-WithoutDuplicates: "+ allMakesWithoutDuplicates);

        return allMakesWithoutDuplicates;
    }
}