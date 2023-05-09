package com.pvlstkv.telephone_exchange.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "telephone_exchanges")
public class TelephoneExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id"
//            , nullable = false
    )
    private District district;

    @OneToMany(mappedBy = "exchange", cascade = CascadeType.ALL)
    private List<Subscriber> subscribers = new ArrayList<>();

    @Column(nullable = false)
    private String firstTwoDigits;


    public void setNumber(String number) {
        this.number = number;
        this.firstTwoDigits = number.substring(0, 2);
    }
}
