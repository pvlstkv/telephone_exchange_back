package com.pvlstkv.telephone_exchange.controller;

import com.pvlstkv.telephone_exchange.mapper.SubscriberMapper;
import com.pvlstkv.telephone_exchange.model.Subscriber;
import com.pvlstkv.telephone_exchange.model.dto.SubscriberDTO;
import com.pvlstkv.telephone_exchange.service.SubscriberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/subscribers")
@AllArgsConstructor
public class SubscriberController {
    private final SubscriberService subscriberService;
    private final SubscriberMapper subscriberMapper;

    @GetMapping("/{id}")
    public SubscriberDTO getSubscriber(@PathVariable Long id) {
        Subscriber subscriber = subscriberService.getSubscriber(id);
        return subscriberMapper.toDTO(subscriber);
    }

//    @GetMapping
//    public List<SubscriberDTO> getAllSubscribers(){
//        return subscriberMapper.toDTOList(subscriberService.getAllSubscribers());
//    }

    @PostMapping
    public SubscriberDTO createSubscriber(@RequestBody SubscriberDTO dto) throws ParseException {
        return subscriberMapper.toDTO(subscriberService.createSubscriber(
                subscriberMapper.toEntity(dto)
        ));
    }

    @PutMapping("/{id}")
    public SubscriberDTO updateSubscriber(@PathVariable Long id, @RequestBody SubscriberDTO dto) throws ParseException {
        return subscriberMapper.toDTO(subscriberService.updateSubscriber(id,
                subscriberMapper.toEntity(dto)
        ));
    }

    @DeleteMapping("/{id}")
    public void deleteSubscriber(@PathVariable Long id) {
        subscriberService.deleteSubscriber(id);
    }
}