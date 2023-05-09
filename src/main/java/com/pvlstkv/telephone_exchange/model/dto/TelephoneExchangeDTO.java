package com.pvlstkv.telephone_exchange.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class TelephoneExchangeDTO {
    private Long id;
    private String number;
    private Long districtId;
    private List<Long> subscribers;
    private String firstTwoDigits;

    // getters and setters
}
