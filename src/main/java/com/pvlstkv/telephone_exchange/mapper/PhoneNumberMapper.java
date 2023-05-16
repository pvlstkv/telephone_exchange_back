package com.pvlstkv.telephone_exchange.mapper;

import com.pvlstkv.telephone_exchange.model.PhoneNumber;
import com.pvlstkv.telephone_exchange.model.Subscriber;
import com.pvlstkv.telephone_exchange.model.TelephoneExchange;
import com.pvlstkv.telephone_exchange.model.dto.PhoneNumberDTO;
import com.pvlstkv.telephone_exchange.model.dto.PhoneNumberExtendedDTO;
import com.pvlstkv.telephone_exchange.model.dto.SubscriberDTO;
import com.pvlstkv.telephone_exchange.model.dto.TelephoneExchangeDTO;
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

    public List<PhoneNumberExtendedDTO> toExtendedDTOList(List<PhoneNumber> allPhoneNumbers) {
        return allPhoneNumbers.stream().map(this::toExtendedDTO).toList();
    }

    private PhoneNumberExtendedDTO toExtendedDTO(PhoneNumber entity) {
        PhoneNumberExtendedDTO dto = new PhoneNumberExtendedDTO();
        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        SubscriberDTO subscriberDTO = new SubscriberDTO();
        Subscriber subscriber = entity.getSubscriber();
        subscriberDTO.setId(subscriber.getId());
        subscriberDTO.setType(subscriber.getType().toString());
        subscriberDTO.setName(subscriber.getName());
        subscriberDTO.setAddress(subscriber.getAddress());
        subscriberDTO.setInstallationDate(subscriber.getInstallationDate().toString());
        subscriberDTO.setLogin(subscriber.getLogin());
        subscriberDTO.setRoles(subscriber.getRoles());
//        dto.setPassword(subscriber.getPassword());
        subscriberDTO.setPhoneNumberIds(subscriber.getPhoneNumbers().stream().map(PhoneNumber::getId).toList());
        TelephoneExchangeDTO exchangeDTO = new TelephoneExchangeDTO();
        TelephoneExchange exchange = entity.getExchange();
        exchangeDTO.setNumber(exchange.getNumber());
        exchangeDTO.setId(exchange.getId());
        exchangeDTO.setDistrictId(exchange.getDistrict().getId());
        exchangeDTO.setFirstTwoDigits(exchange.getFirstTwoDigits());
        exchangeDTO.setSubscriberIds(exchange.getSubscribers().stream().map(Subscriber::getId).toList());
        dto.setExchange(exchangeDTO);
        return dto;
    }
}