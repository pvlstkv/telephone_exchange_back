package com.pvlstkv.telephone_exchange.service;

import com.pvlstkv.telephone_exchange.model.Subscriber;
import com.pvlstkv.telephone_exchange.repository.SubscriberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        return subscriberRepository.save(subscriber);
    }

    public void deleteSubscriber(Long id) {
        subscriberRepository.deleteById(id);
    }
}