package com.pvlstkv.telephone_exchange.mapper;

import com.pvlstkv.telephone_exchange.model.PhoneNumber;
import com.pvlstkv.telephone_exchange.model.dto.PhoneNumberDTO;
import com.pvlstkv.telephone_exchange.service.SubscriberService;
import com.pvlstkv.telephone_exchange.service.TelephoneExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PhoneNumberMapper {
    private SubscriberService subscriberService;
    private TelephoneExchangeService exchangeService;

    public PhoneNumberDTO toDto(PhoneNumber entity) {
        PhoneNumberDTO dto = new PhoneNumberDTO();
        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        dto.setSubscriberId(entity.getSubscriber().getId());
        dto.setExchangeId(dto.getExchangeId());
        return dto;
    }

    public PhoneNumber toEntity(PhoneNumberDTO dto) {
        PhoneNumber entity = new PhoneNumber();
        entity.setId(dto.getId());
        entity.setPhone(dto.getPhone());
        entity.setSubscriber(subscriberService.getSubscriber(dto.getId()));
        entity.setExchange(exchangeService.getById(dto.getExchangeId()));
        return entity;
    }

    public List<PhoneNumberDTO> toDtoList(List<PhoneNumber> phoneNumbers) {
        return phoneNumbers.stream().map(this::toDto).toList();
    }

    public List<PhoneNumber> toEntityList(List<PhoneNumberDTO> phoneNumbers) {
        return phoneNumbers.stream().map(this::toEntity).toList();
    }
}