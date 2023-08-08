package com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.dao;

import com.devslingtest.walidzhani.springbootcarsalesgaragerestapi.entities.GarageCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
// collectionResourceRel = "garageCatalog" => Name of JSON Entry -- path = "garage-catalog" => /garage-catalog
@RepositoryRestResource(collectionResourceRel = "garageCatalog", path = "garage-catalog")
public interface GarageCatalogRepository extends JpaRepository<GarageCatalog, Integer> {
    // JpaRepository<GarageCatalog, Integer> => Entity: "GarageCatalog" // PrimaryKey: "Integer"

}