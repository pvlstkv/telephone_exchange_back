package com.pvlstkv.telephone_exchange.model;

import com.pvlstkv.telephone_exchange.authorization.ERole;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "subscribers",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "login"),
                @UniqueConstraint(columnNames = "name")
        })
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false)
    private String type;

//    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
    private String address;

//    @Column(nullable = false)
    private LocalDate installationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exchange_id"
//            , nullable = false
    )
    private TelephoneExchange exchange;

    @OneToMany(mappedBy = "subscriber", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    private Set<ERole> roles = new HashSet<>();

    public Subscriber() {
    }

    public Subscriber(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }


    public Subscriber(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
