package com.pvlstkv.telephone_exchange.mapper;

import com.pvlstkv.telephone_exchange.model.ESubscriberType;
import com.pvlstkv.telephone_exchange.model.PhoneNumber;
import com.pvlstkv.telephone_exchange.model.Subscriber;
import com.pvlstkv.telephone_exchange.model.dto.SubscriberDTO;
import com.pvlstkv.telephone_exchange.repository.PhoneNumberRepository;
import com.pvlstkv.telephone_exchange.repository.SubscriberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
@AllArgsConstructor
public class SubscriberMapper {

    private SubscriberRepository subscriberRepository;

    private PhoneNumberRepository numberRepository;

    private PasswordEncoder encoder;


    public SubscriberDTO toDTO(Subscriber subscriber) {
        SubscriberDTO dto = new SubscriberDTO();
        dto.setId(subscriber.getId());
        dto.setType(subscriber.getType().toString());
        dto.setName(subscriber.getName());
        dto.setAddress(subscriber.getAddress());
        dto.setInstallationDate(subscriber.getInstallationDate().toString());
        dto.setLogin(subscriber.getLogin());
        dto.setRoles(subscriber.getRoles());
//        dto.setPassword(subscriber.getPassword());
        dto.setPhoneNumberIds(subscriber.getPhoneNumbers().stream().map(PhoneNumber::getId).toList());
        return dto;
    }

    public Subscriber toEntity(SubscriberDTO dto) throws ParseException {
        Subscriber subscriber = new Subscriber();
        subscriber.setId(dto.getId());
        subscriber.setType(ESubscriberType.valueOf(dto.getType()));
        subscriber.setName(dto.getName());
        subscriber.setAddress(dto.getAddress());
        subscriber.setInstallationDate(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getInstallationDate()));
        subscriber.setLogin(dto.getLogin());
        subscriber.setRoles(dto.getRoles());
        if (dto.isEncodePassword()) {
            subscriber.setPassword(encoder.encode(dto.getPassword()));
        }
//        subscriber.setPassword(dto.getPassword());
        subscriber.setPhoneNumbers(numberRepository.findAllById(dto.getPhoneNumberIds()));
        return subscriber;
    }

    public List<Long> toDTOList(List<Subscriber> subscribers) {
        return subscribers.stream().map(Subscriber::getId).toList();
    }

    public List<Subscriber> toEntityList(List<Long> subscriberIds) {
        return subscriberRepository.findAllById(subscriberIds);
    }
}
