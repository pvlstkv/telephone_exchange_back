package com.pvlstkv.telephone_exchange.controller;

import com.pvlstkv.telephone_exchange.mapper.TelephoneExchangeMapper;
import com.pvlstkv.telephone_exchange.model.dto.TelephoneExchangeDTO;
import com.pvlstkv.telephone_exchange.service.TelephoneExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telephone-exchanges")
public class TelephoneExchangeController {
    @Autowired
    private TelephoneExchangeService service;

    private TelephoneExchangeMapper exchangeMapper;

    @GetMapping("/{id}")
    public TelephoneExchangeDTO getById(@PathVariable Long id) {
        return exchangeMapper.toDto(service.getById(id));
    }

    @PostMapping
    public TelephoneExchangeDTO create(@RequestBody TelephoneExchangeDTO dto) {
        return exchangeMapper.toDto(service.create(exchangeMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public TelephoneExchangeDTO update(@PathVariable Long id, @RequestBody TelephoneExchangeDTO dto) {
        return exchangeMapper.toDto(service.update(exchangeMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
