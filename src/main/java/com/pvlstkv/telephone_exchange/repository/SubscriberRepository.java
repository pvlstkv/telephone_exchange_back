package com.pvlstkv.telephone_exchange.repository;

import com.pvlstkv.telephone_exchange.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@RepositoryRestResource(collectionResourceRel = "subscribers", path = "subscriber")

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

    Optional<Subscriber> findByName(String name);

    Optional<Subscriber> findByLogin(String login);

    Boolean existsByName(String name);



}
