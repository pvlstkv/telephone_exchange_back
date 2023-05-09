package com.pvlstkv.telephone_exchange.model.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PhoneNumberDTO {
    private Long id;
    private String phone;
    private Long subscriberId;

    private Long exchangeId;

    // getters and setters
}