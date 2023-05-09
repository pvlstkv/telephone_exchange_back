package com.pvlstkv.telephone_exchange.model.dto;

import com.pvlstkv.telephone_exchange.authorization.ERole;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class SubscriberDTO {
    private Long id;

    private String type;

    private String name;

    private String address;

    private LocalDate installationDate;

    private String login;

    private boolean encodePassword = false;
    private String password;

    private List<Long> phoneNumberIds;

    private Set<ERole> roles;


    // getters and setters
}