package com.pvlstkv.telephone_exchange.mapper;

import com.pvlstkv.telephone_exchange.model.Subscriber;
import com.pvlstkv.telephone_exchange.model.dto.SubscriberDTO;
import com.pvlstkv.telephone_exchange.repository.SubscriberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubscriberMapper {

    private SubscriberRepository subscriberRepository;

    private PhoneNumberMapper phoneNumberMapper;
    public SubscriberDTO toDTO(Subscriber subscriber) {
        SubscriberDTO dto = new SubscriberDTO();
        dto.setId(subscriber.getId());
        dto.setType(subscriber.getType());
        dto.setName(subscriber.getName());
        dto.setAddress(subscriber.getAddress());
        dto.setInstallationDate(subscriber.getInstallationDate());
        dto.setLogin(subscriber.getLogin());
//        dto.setPassword(subscriber.getPassword());
        dto.setPhoneNumbers(phoneNumberMapper.toDtoList(subscriber.getPhoneNumbers()));
        return dto;
    }

    public Subscriber toEntity(SubscriberDTO dto) {
        Subscriber subscriber = new Subscriber();
        subscriber.setId(dto.getId());
        subscriber.setType(dto.getType());
        subscriber.setName(dto.getName());
        subscriber.setAddress(dto.getAddress());
        subscriber.setInstallationDate(dto.getInstallationDate());
        subscriber.setLogin(dto.getLogin());
//        subscriber.setPassword(dto.getPassword());
        subscriber.setPhoneNumbers(phoneNumberMapper.toEntityList(dto.getPhoneNumbers()));
        return subscriber;
    }

    public List<Long> toDtoList(List<Subscriber> subscribers) {
        return subscribers.stream().map(Subscriber::getId).toList();
    }

    public List<Subscriber> toEntityList(List<Long> subscriberIds) {
        return subscriberRepository.findAllById(subscriberIds);
    }
}
