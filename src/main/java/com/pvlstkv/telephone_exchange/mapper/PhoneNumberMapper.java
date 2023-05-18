package com.pvlstkv.telephone_exchange.mapper;

import com.pvlstkv.telephone_exchange.model.PhoneNumber;
import com.pvlstkv.telephone_exchange.model.dto.PhoneNumberDTO;
import com.pvlstkv.telephone_exchange.model.dto.PhoneNumberExtendedDTO;
import com.pvlstkv.telephone_exchange.service.SubscriberService;
import com.pvlstkv.telephone_exchange.service.TelephoneExchangeService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PhoneNumberMapper {
    private SubscriberService subscriberService;
    private TelephoneExchangeService exchangeService;
    private TelephoneExchangeMapper exchangeMapper;
    private SubscriberMapper subscriberMapper;

    public PhoneNumberMapper(SubscriberService subscriberService, TelephoneExchangeService exchangeService,
                             @Lazy TelephoneExchangeMapper exchangeMapper,
                             @Lazy SubscriberMapper subscriberMapper) {
        this.subscriberService = subscriberService;
        this.exchangeService = exchangeService;
        this.exchangeMapper = exchangeMapper;
        this.subscriberMapper = subscriberMapper;
    }

    public PhoneNumberDTO toDTO(PhoneNumber entity) {
        PhoneNumberDTO dto = new PhoneNumberDTO();
        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        dto.setSubscriberId(entity.getSubscriber() == null ?
                null : entity.getSubscriber().getId());
        dto.setExchangeId(entity.getExchange().getId());
        return dto;
    }

    public PhoneNumber toEntity(PhoneNumberDTO dto) {
        PhoneNumber entity = new PhoneNumber();
        entity.setId(dto.getId());
        entity.setExchange(exchangeService.getTelephoneExchange(dto.getExchangeId()));
        entity.setPhone(dto.getPhone());
        entity.setSubscriber(dto.getSubscriberId() == null ? null : subscriberService.getSubscriber(dto.getSubscriberId()));
        entity.addPrefix();
        return entity;
    }

    public List<PhoneNumberDTO> toDTOList(List<PhoneNumber> phoneNumbers) {
        return phoneNumbers.stream().map(this::toDTO).toList();
    }

    public List<PhoneNumber> toEntityList(List<PhoneNumberDTO> phoneNumbers) {
        return phoneNumbers.stream().map(this::toEntity).toList();
    }

    public List<PhoneNumberExtendedDTO> toExtendedDTOList(List<PhoneNumber> allPhoneNumbers) {
        return allPhoneNumbers.stream().map(this::toExtendedDTO).toList();
    }

    private PhoneNumberExtendedDTO toExtendedDTO(PhoneNumber entity) {
        PhoneNumberExtendedDTO dto = new PhoneNumberExtendedDTO();
        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        dto.setSubscriber(entity.getSubscriber() == null ?
                null : subscriberMapper.toDTO(entity.getSubscriber()));
        dto.setExchange(exchangeMapper.toDTO(entity.getExchange()));
        return dto;
    }
}