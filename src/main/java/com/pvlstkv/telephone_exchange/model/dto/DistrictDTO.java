package com.pvlstkv.telephone_exchange.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class DistrictDTO {
    private Long id;
    private String name;
    private Long cityId;
    private List<Long> exchangeIds;
    // getters and setters
}
