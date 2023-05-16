package com.pvlstkv.telephone_exchange.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PhoneNumberExtendedDTO {
    private Long id;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "");
    private String phone;
    private SubscriberDTO subscriber;

    private TelephoneExchangeDTO exchange;

}
