package com.pvlstkv.telephone_exchange.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@RequiredArgsConstructor
public class TelephoneExchangeExtendedDTO {
    private Long id;
    private String number;
    private DistrictDTO district;
    private List<SubscriberDTO> subscribers;
    private String firstTwoDigits;
}
