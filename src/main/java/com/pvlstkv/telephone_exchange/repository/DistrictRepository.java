package com.pvlstkv.telephone_exchange.repository;

import com.pvlstkv.telephone_exchange.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@RepositoryRestResource(collectionResourceRel = "districts", path = "district")

public interface DistrictRepository extends JpaRepository<District, Long> {
    Optional<District> findById(Long id);
}
