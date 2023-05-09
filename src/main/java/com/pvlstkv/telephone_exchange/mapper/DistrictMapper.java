package com.pvlstkv.telephone_exchange.mapper;

import com.pvlstkv.telephone_exchange.model.City;
import com.pvlstkv.telephone_exchange.model.District;
import com.pvlstkv.telephone_exchange.model.TelephoneExchange;
import com.pvlstkv.telephone_exchange.model.dto.DistrictDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DistrictMapper {
    public DistrictDTO toDTO(District district) {
        DistrictDTO dto = new DistrictDTO();
        dto.setId(district.getId());
        dto.setName(district.getName());
        dto.setCityId(district.getCity().getId());
        dto.setExchangeIds(district.getExchanges().stream().map(TelephoneExchange::getId).collect(Collectors.toList()));
        return dto;
    }

    public District toEntity(DistrictDTO dto, City city, List<TelephoneExchange> exchanges) {
        District district = new District();
        district.setId(dto.getId());
        district.setName(dto.getName());
        district.setCity(city);
        district.setExchanges(exchanges);
        return district;
    }
}
