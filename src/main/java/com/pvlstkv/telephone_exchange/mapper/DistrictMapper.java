package com.pvlstkv.telephone_exchange.mapper;

import com.pvlstkv.telephone_exchange.model.City;
import com.pvlstkv.telephone_exchange.model.District;
import com.pvlstkv.telephone_exchange.model.TelephoneExchange;
import com.pvlstkv.telephone_exchange.model.dto.CityDTO;
import com.pvlstkv.telephone_exchange.model.dto.DistrictDTO;
import com.pvlstkv.telephone_exchange.model.dto.DistrictExtendedDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DistrictMapper {

    private final TelephoneExchangeMapper telephoneExchangeMapper;
    public DistrictDTO toDTO(District district) {
        DistrictDTO dto = new DistrictDTO();
        dto.setId(district.getId());
        dto.setName(district.getName());
        dto.setCityId(district.getCity().getId());
        dto.setExchangeIds(district.getExchanges() == null ?
                null
                :district.getExchanges().stream().map(TelephoneExchange::getId).collect(Collectors.toList()));
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

    public List<DistrictDTO> toDTOList(List<District> allDistricts) {
        return allDistricts.stream().map(this::toDTO).toList();
    }

    public List<DistrictExtendedDTO> toExtendedDTOList(List<District> districts) {
        return districts.stream().map(this::toExtendedDTO).toList();
    }

    private DistrictExtendedDTO toExtendedDTO(District district) {
        DistrictExtendedDTO dto = new DistrictExtendedDTO();
        dto.setId(district.getId());
        dto.setName(district.getName());
        dto.setCity(new CityDTO(district.getCity().getId(), district.getCity().getName(),
                district.getExchanges().stream().map(TelephoneExchange::getId).toList()));
        dto.setExchanges(telephoneExchangeMapper.toDTOList(district.getExchanges()));
        return dto;
    }
}
