package com.pvlstkv.telephone_exchange.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class DistrictExtendedDTO {
    private Long id;
    private String name;
    private CityDTO city;
    private List<TelephoneExchangeDTO> exchanges;
}
