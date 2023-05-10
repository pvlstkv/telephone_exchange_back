package com.pvlstkv.telephone_exchange.mapper;

import com.pvlstkv.telephone_exchange.model.TelephoneExchange;
import com.pvlstkv.telephone_exchange.model.dto.TelephoneExchangeDTO;
import com.pvlstkv.telephone_exchange.repository.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
@AllArgsConstructor
public class TelephoneExchangeMapper {

    private SubscriberMapper subscriberMapper;

    private DistrictRepository districtRepository;

    public TelephoneExchangeDTO toDTO(TelephoneExchange entity) {
        TelephoneExchangeDTO dto = new TelephoneExchangeDTO();
        dto.setId(entity.getId());
        dto.setNumber(entity.getNumber());
        dto.setDistrictId(entity.getDistrict().getId());
        dto.setSubscriberIds(subscriberMapper.toDTOList(entity.getSubscribers()));
        dto.setFirstTwoDigits(entity.getFirstTwoDigits());
        return dto;
    }

    public TelephoneExchange toEntity(TelephoneExchangeDTO dto) {
        TelephoneExchange entity = new TelephoneExchange();
        entity.setId(dto.getId());
        entity.setNumber(dto.getNumber());
        entity.setDistrict(districtRepository.findById(dto.getDistrictId()).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "не найден район с id = " + dto.getId())
                )
        );
        entity.setFirstTwoDigits(dto.getFirstTwoDigits());
        entity.setSubscribers(subscriberMapper.toEntityList(dto.getSubscriberIds()));
        return entity;
    }

    public List<TelephoneExchangeDTO> toDTOList(List<TelephoneExchange> allTelephoneExchanges) {
        return allTelephoneExchanges.stream().map(this::toDTO).toList();
    }
}
