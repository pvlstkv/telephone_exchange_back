package com.pvlstkv.telephone_exchange.service;

import com.pvlstkv.telephone_exchange.model.PhoneNumber;
import com.pvlstkv.telephone_exchange.model.Subscriber;
import com.pvlstkv.telephone_exchange.model.dto.PhoneNumberDTO;
import com.pvlstkv.telephone_exchange.repository.PhoneNumberRepository;
import com.pvlstkv.telephone_exchange.repository.SubscriberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PhoneNumberService {
    private PhoneNumberRepository phoneNumberRepository;

    private SubscriberRepository subscriberRepository;

    public PhoneNumber getPhoneNumber(Long id) {
        return phoneNumberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("PhoneNumber not found"));
    }

    public PhoneNumber createPhoneNumber(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }

    public PhoneNumber updatePhoneNumber(Long id, PhoneNumberDTO dto) {
        PhoneNumber entity = phoneNumberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("PhoneNumber not found"));
        Subscriber subscriber = subscriberRepository.findById(dto.getSubscriberId()).orElseThrow(() -> new EntityNotFoundException("Subscriber not found"));
        entity.setPhone(dto.getPhone());
        entity.setSubscriber(subscriber);
        entity = phoneNumberRepository.save(entity);
        return entity;
    }

    public void deletePhoneNumber(Long id) {
        phoneNumberRepository.deleteById(id);
    }
}