package com.pvlstkv.telephone_exchange.repository;

import com.pvlstkv.telephone_exchange.model.PhoneNumber;
import com.pvlstkv.telephone_exchange.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "phones", path = "phone")

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
    List<PhoneNumber> findAllBySubscriber(Subscriber subscriber);
}
