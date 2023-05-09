package com.pvlstkv.telephone_exchange.model.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PhoneNumberDTO {
    private Long id;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "");
    private String phone;
    private Long subscriberId;

    private Long exchangeId;

    // getters and setters
}