package com.pvlstkv.telephone_exchange.mapper;

import com.pvlstkv.telephone_exchange.model.TelephoneExchange;
import com.pvlstkv.telephone_exchange.model.dto.TelephoneExchangeDTO;
import com.pvlstkv.telephone_exchange.repository.DistrictRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TelephoneExchangeMapper {

    private SubscriberMapper subscriberMapper;

    private DistrictRepository districtRepository;

    public TelephoneExchangeDTO toDto(TelephoneExchange entity) {
        TelephoneExchangeDTO dto = new TelephoneExchangeDTO();
        dto.setId(entity.getId());
        dto.setNumber(entity.getNumber());
        dto.setDistrictId(entity.getDistrict().getId());
        dto.setSubscribers(subscriberMapper.toDtoList(entity.getSubscribers()));
        dto.setFirstTwoDigits(entity.getFirstTwoDigits());
        return dto;
    }

    public TelephoneExchange toEntity(TelephoneExchangeDTO dto) {
        TelephoneExchange entity = new TelephoneExchange();
        entity.setId(dto.getId());
        entity.setNumber(dto.getNumber());
        entity.setDistrict(districtRepository.findById(dto.getId()).orElseThrow(
                () -> new EntityNotFoundException("District with id = " + dto.getId())
                )
        );
        entity.setSubscribers(subscriberMapper.toEntityList(dto.getSubscribers()));
        return entity;
    }
}
