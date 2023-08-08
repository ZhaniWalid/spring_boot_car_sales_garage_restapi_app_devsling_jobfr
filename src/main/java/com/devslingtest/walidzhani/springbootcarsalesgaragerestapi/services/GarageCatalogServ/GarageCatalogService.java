package com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.services.GarageCatalogServ;

import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.entities.GarageCatalog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GarageCatalogService {
    List<GarageCatalog> findAllGarageCatalogs();
}
