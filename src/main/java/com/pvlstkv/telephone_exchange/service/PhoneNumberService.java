package com.pvlstkv.telephone_exchange.service;

import com.pvlstkv.telephone_exchange.model.PhoneNumber;
import com.pvlstkv.telephone_exchange.model.Subscriber;
import com.pvlstkv.telephone_exchange.repository.PhoneNumberRepository;
import com.pvlstkv.telephone_exchange.repository.SubscriberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PhoneNumberService {
    private PhoneNumberRepository phoneNumberRepository;

    private SubscriberRepository subscriberRepository;

    public List<PhoneNumber> getPhoneNumber(List<Long> ids) {
        return phoneNumberRepository.findAllById(ids);
    }

    public PhoneNumber createPhoneNumber(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }

    public PhoneNumber updatePhoneNumber(Long id, PhoneNumber phoneNumber) {
        PhoneNumber entity = phoneNumberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("PhoneNumber not found"));
        if (phoneNumber.getSubscriber() != null) {
            Subscriber subscriber = subscriberRepository.findById(phoneNumber.getSubscriber().getId()).orElseThrow(() -> new EntityNotFoundException("Subscriber not found"));
            entity.setSubscriber(subscriber);
        }
        entity.setPhone(phoneNumber.getPhone());
        entity.setExchange(phoneNumber.getExchange());
        entity = phoneNumberRepository.save(entity);
        return entity;
    }

    public void deletePhoneNumber(Long id) {
        phoneNumberRepository.deleteById(id);
    }

    public List<PhoneNumber> getAllPhoneNumbers() {
        return phoneNumberRepository.findAll();
    }
}