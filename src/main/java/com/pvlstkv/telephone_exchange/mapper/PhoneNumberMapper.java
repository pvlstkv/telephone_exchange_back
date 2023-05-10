package com.pvlstkv.telephone_exchange.mapper;

import com.pvlstkv.telephone_exchange.model.PhoneNumber;
import com.pvlstkv.telephone_exchange.model.dto.PhoneNumberDTO;
import com.pvlstkv.telephone_exchange.service.SubscriberService;
import com.pvlstkv.telephone_exchange.service.TelephoneExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PhoneNumberMapper {
    private SubscriberService subscriberService;
    private TelephoneExchangeService exchangeService;

    public PhoneNumberDTO toDTO(PhoneNumber entity) {
        PhoneNumberDTO dto = new PhoneNumberDTO();
        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        dto.setSubscriberId(entity.getSubscriber().getId());
        dto.setExchangeId(entity.getExchange().getId());
        return dto;
    }

    public PhoneNumber toEntity(PhoneNumberDTO dto) {
        PhoneNumber entity = new PhoneNumber();
        entity.setId(dto.getId());
        entity.setExchange(exchangeService.getTelephoneExchange(dto.getExchangeId()));
        entity.setPhone(dto.getPhone());
        entity.setSubscriber(subscriberService.getSubscriber(dto.getSubscriberId()));
        entity.addPrefix();
        return entity;
    }

    public List<PhoneNumberDTO> toDTOList(List<PhoneNumber> phoneNumbers) {
        return phoneNumbers.stream().map(this::toDTO).toList();
    }

    public List<PhoneNumber> toEntityList(List<PhoneNumberDTO> phoneNumbers) {
        return phoneNumbers.stream().map(this::toEntity).toList();
    }
}