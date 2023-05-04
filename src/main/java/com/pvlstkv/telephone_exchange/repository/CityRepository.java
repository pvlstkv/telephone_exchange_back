package com.pvlstkv.telephone_exchange.repository;

import com.pvlstkv.telephone_exchange.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cities", path = "users")
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    List<City> findByName(@Param("name") String name);

}
