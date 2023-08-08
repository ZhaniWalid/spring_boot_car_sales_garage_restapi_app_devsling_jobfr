package com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.dao;

import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    // JpaRepository<Car, Integer> => Entity: "Car" // PrimaryKey: "Integer"
}
