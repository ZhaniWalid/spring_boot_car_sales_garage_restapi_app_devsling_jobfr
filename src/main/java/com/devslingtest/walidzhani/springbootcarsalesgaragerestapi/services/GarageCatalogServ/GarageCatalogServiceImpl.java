package com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.services.GarageCatalogServ;

import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.entities.GarageCatalog;
import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.services.CarServ.CarService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GarageCatalogService")
public class GarageCatalogServiceImpl implements GarageCatalogService {
    private static final Logger logger = LoggerFactory.getLogger(GarageCatalogServiceImpl.class);

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    CarService carService;

    public GarageCatalogServiceImpl() {
    }

    @Override
    public List<GarageCatalog> findAllGarageCatalogs() {
        List<GarageCatalog> garageCatalogList
                = entityManager.createQuery("SELECT gc FROM GarageCatalog gc", GarageCatalog.class).getResultList();

        for (GarageCatalog garageCatalog : garageCatalogList) {
            garageCatalog.setCarList(carService.findAllCars());
        }
        logger.info("findAllGarageCatalogs(): "+ garageCatalogList);

        return garageCatalogList;
    }
}