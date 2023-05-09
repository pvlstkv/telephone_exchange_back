package com.pvlstkv.telephone_exchange.service;

import com.pvlstkv.telephone_exchange.mapper.TelephoneExchangeMapper;
import com.pvlstkv.telephone_exchange.model.Subscriber;
import com.pvlstkv.telephone_exchange.model.TelephoneExchange;
import com.pvlstkv.telephone_exchange.repository.DistrictRepository;
import com.pvlstkv.telephone_exchange.repository.SubscriberRepository;
import com.pvlstkv.telephone_exchange.repository.TelephoneExchangeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TelephoneExchangeService {

    private TelephoneExchangeRepository repository;


    private TelephoneExchangeMapper mapper;

    private DistrictRepository districtRepository;

    private SubscriberRepository subscriberRepository;

    public TelephoneExchange getById(Long id) {
        TelephoneExchange entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("TelephoneExchange with id = " + id));
        return entity;
    }

    public TelephoneExchange create(TelephoneExchange exchange) {
        return repository.save(exchange);
    }

    public TelephoneExchange update(TelephoneExchange exchange) {
        TelephoneExchange entity = repository.findById(exchange.getId())
                .orElseThrow(() -> new EntityNotFoundException("TelephoneExchange with id = " + exchange.getId()));
        entity.setNumber(exchange.getNumber());
        entity.setDistrict(districtRepository.findById(exchange.getDistrict().getId()).orElseThrow(
                () -> new EntityNotFoundException("District with id = " + exchange.getDistrict().getId())
        ));
        entity.setSubscribers(subscriberRepository.findAllById(exchange.getSubscribers().stream().map(Subscriber::getId).toList()));
        entity.setFirstTwoDigits(exchange.getFirstTwoDigits());
        entity = repository.save(entity);
        return entity;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<TelephoneExchange> findAllById(List<Long> exchangeIds) {
        return repository.findAllById(exchangeIds);
    }
}