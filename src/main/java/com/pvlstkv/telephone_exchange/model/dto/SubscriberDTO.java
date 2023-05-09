package com.pvlstkv.telephone_exchange.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
public class SubscriberDTO {
    private Long id;

    private String type;

    private String name;

    private String address;

    private LocalDate installationDate;

    private String login;

    private String password;

    private Long phoneNumberId;

    private List<PhoneNumberDTO> phoneNumbers;


    // getters and setters
}