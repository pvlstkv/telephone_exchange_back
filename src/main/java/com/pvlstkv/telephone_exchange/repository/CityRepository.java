package com.pvlstkv.telephone_exchange.repository;

import com.pvlstkv.telephone_exchange.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "cities", path = "city")
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByName(@Param("name") String name);

}
