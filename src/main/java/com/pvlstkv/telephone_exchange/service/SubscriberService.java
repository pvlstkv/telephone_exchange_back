package com.pvlstkv.telephone_exchange.service;

import com.pvlstkv.telephone_exchange.model.Subscriber;
import com.pvlstkv.telephone_exchange.repository.SubscriberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class SubscriberService {
    private final SubscriberRepository subscriberRepository;


    public Subscriber getSubscriber(Long id) {
        return subscriberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subscriber not found with id " + id));
    }

    public Subscriber createSubscriber(Subscriber subscriber) {
        return subscriberRepository.save(subscriber);
    }

    public Subscriber updateSubscriber(Subscriber subscriber) {
        Subscriber entity = subscriberRepository.findById(subscriber.getId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "не найден подписчик с id = " + subscriber.getId())
        );
        entity.setPhoneNumbers(subscriber.getPhoneNumbers());
        entity.setAddress(subscriber.getAddress());
        entity.setName(subscriber.getName());
        entity.setLogin(subscriber.getLogin());
        entity.setExchange(subscriber.getExchange());
        entity.setType(subscriber.getType());
        entity.setInstallationDate(subscriber.getInstallationDate());
        entity.setPassword(subscriber.getPassword());
        entity.setRoles(subscriber.getRoles());
        return subscriberRepository.save(entity);
    }

    public void deleteSubscriber(Long id) {
        subscriberRepository.deleteById(id);
    }
}