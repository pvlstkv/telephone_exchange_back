package com.pvlstkv.telephone_exchange.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CityDTO {
    private Long id;
    private String name;
    private List<Long> districtIds = new ArrayList<>();

    // getters and setters
}
