package com.pvlstkv.telephone_exchange.controller;

import com.pvlstkv.telephone_exchange.mapper.TelephoneExchangeMapper;
import com.pvlstkv.telephone_exchange.model.dto.TelephoneExchangeDTO;
import com.pvlstkv.telephone_exchange.service.TelephoneExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telephone-exchanges")
@AllArgsConstructor

public class TelephoneExchangeController {
    private TelephoneExchangeService service;

    private TelephoneExchangeMapper exchangeMapper;

    @GetMapping("/{id}")
    public TelephoneExchangeDTO getById(@PathVariable Long id) {
        return exchangeMapper.toDto(service.getTelephoneExchange(id));
    }

    @PostMapping
    public TelephoneExchangeDTO create(@RequestBody TelephoneExchangeDTO dto) {
        return exchangeMapper.toDto(service.createTelephoneExchange(exchangeMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public TelephoneExchangeDTO update(@PathVariable Long id, @RequestBody TelephoneExchangeDTO dto) {
        return exchangeMapper.toDto(service.updateTelephoneExchange(exchangeMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTelephoneExchange(id);
    }
}
