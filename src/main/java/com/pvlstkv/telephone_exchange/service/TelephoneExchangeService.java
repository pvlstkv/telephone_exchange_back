package com.pvlstkv.telephone_exchange.service;

import com.pvlstkv.telephone_exchange.model.Subscriber;
import com.pvlstkv.telephone_exchange.model.TelephoneExchange;
import com.pvlstkv.telephone_exchange.repository.DistrictRepository;
import com.pvlstkv.telephone_exchange.repository.SubscriberRepository;
import com.pvlstkv.telephone_exchange.repository.TelephoneExchangeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TelephoneExchangeService {

    private TelephoneExchangeRepository repository;

    private DistrictRepository districtRepository;

    private SubscriberRepository subscriberRepository;

    public TelephoneExchange getTelephoneExchange(Long id) {
        TelephoneExchange entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("TelephoneExchange with id = " + id));
        return entity;
    }

    public TelephoneExchange createTelephoneExchange(TelephoneExchange exchange) {
        return repository.save(exchange);
    }

    public TelephoneExchange updateTelephoneExchange(TelephoneExchange exchange) {
        TelephoneExchange entity = repository.findById(exchange.getId())
                .orElseThrow(() -> new EntityNotFoundException("не найден райно с id = " + exchange.getId()));
        entity.setNumber(exchange.getNumber());
        entity.setDistrict(districtRepository.findById(exchange.getDistrict().getId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "не найден район с id = " + exchange.getDistrict().getId())
        ));
        entity.setSubscribers(subscriberRepository.findAllById(exchange.getSubscribers().stream().map(Subscriber::getId).toList()));
        entity.setFirstTwoDigits(exchange.getFirstTwoDigits());
        entity = repository.save(entity);
        return entity;
    }

    public void deleteTelephoneExchange(Long id) {
        repository.deleteById(id);
    }

    public List<TelephoneExchange> getAllTelephoneExchange(List<Long> exchangeIds) {
        return repository.findAllById(exchangeIds);
    }
}