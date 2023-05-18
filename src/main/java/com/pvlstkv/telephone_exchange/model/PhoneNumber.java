package com.pvlstkv.telephone_exchange.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "phone_numbers")
@ToString(exclude = {"subscriber", "exchange"})
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriber_id"
//            , nullable = false
    )
    private Subscriber subscriber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exchange_id"
//            , nullable = false
    )
    private TelephoneExchange exchange;


    public void addPrefix() {
        this.phone = this.exchange.getFirstTwoDigits() + this.phone;
    }
//    public void setPhone(String phone) {
//        this.phone = this.exchange.getFirstTwoDigits() + phone;
//    }
//    public String getPhone(){
//        return this.phone.substring(2);
//    }
}
