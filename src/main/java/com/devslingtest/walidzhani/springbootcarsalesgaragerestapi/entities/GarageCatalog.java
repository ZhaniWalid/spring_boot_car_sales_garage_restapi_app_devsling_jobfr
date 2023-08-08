package com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "garage_catalog")
@Data // Lombock annotation => Auto generate the getter(s)/setter(s) behind the scenes & Reduce boilerplate code.
public class GarageCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_catalog")
    private int idCatalog;

    @Column(name = "garage_name")
    private String garageName;

    @Transient // You can mark it as @Transient if it doesn't exist on DB table.
    private List<Car> carList;

    @Override
    public String toString() {
        return "GarageCatalog{" +
                "idCatalog=" + idCatalog +
                ", garageName='" + garageName + '\'' +
                ", carList=" + carList +
                '}';
    }

    // We can get rid of the Getters & Setters because the @Data Lombock annotation will do it behind the scenes
    /* public int getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(int idCatalog) {
        this.idCatalog = idCatalog;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    } */
}