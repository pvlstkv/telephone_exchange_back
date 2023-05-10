package com.pvlstkv.telephone_exchange.mapper;

import com.pvlstkv.telephone_exchange.model.City;
import com.pvlstkv.telephone_exchange.model.District;
import com.pvlstkv.telephone_exchange.model.dto.CityDTO;
import com.pvlstkv.telephone_exchange.repository.DistrictRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CityMapper {

    private final DistrictRepository districtRepository;

    public CityDTO toDTO(City city) {
        CityDTO dto = new CityDTO();
        dto.setId(city.getId());
        dto.setName(city.getName());
        dto.setDistrictIds(city.getDistricts().stream().map(District::getId).collect(Collectors.toList()));
        return dto;
    }

    public City toEntity(CityDTO dto) {
        City city = new City();
        city.setId(dto.getId());
        city.setName(dto.getName());
        List<District> districts = dto.getDistrictIds().stream().map(id -> {
            District district = districtRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("District with id = " + id)
            );
            district.setId(id);
            return district;
        }).collect(Collectors.toList());
        city.setDistricts(districts);
        return city;
    }


    public List<CityDTO> toDTOList(List<City> allCities) {
        return allCities.stream().map(this::toDTO).toList();
    }
}
