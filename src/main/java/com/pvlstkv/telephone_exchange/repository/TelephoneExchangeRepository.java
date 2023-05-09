package com.pvlstkv.telephone_exchange.repository;

import com.pvlstkv.telephone_exchange.model.TelephoneExchange;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(collectionResourceRel = "telephone_exchanges", path = "telephone_exchange")

public interface TelephoneExchangeRepository extends JpaRepository<TelephoneExchange, Long> {
}
