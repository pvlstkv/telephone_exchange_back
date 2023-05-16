package com.pvlstkv.telephone_exchange.model.dto;

import com.pvlstkv.telephone_exchange.authorization.ERole;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class SubscriberExtendedDTO {

    private Long id;
    private String type;
    private String name;
    private String address;
    private String installationDate;
    private String login;
    private boolean encodePassword = false;
    private String password;
    private List<PhoneNumberDTO> phoneNumbers;
    private Set<ERole> roles;
}
