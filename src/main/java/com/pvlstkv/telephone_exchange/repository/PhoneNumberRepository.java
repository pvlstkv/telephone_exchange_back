package com.pvlstkv.telephone_exchange.repository;

import com.pvlstkv.telephone_exchange.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(collectionResourceRel = "phones", path = "phone")

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
}
