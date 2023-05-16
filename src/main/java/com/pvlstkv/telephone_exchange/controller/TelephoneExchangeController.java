package com.pvlstkv.telephone_exchange.controller;

import com.pvlstkv.telephone_exchange.mapper.TelephoneExchangeMapper;
import com.pvlstkv.telephone_exchange.model.dto.TelephoneExchangeDTO;
import com.pvlstkv.telephone_exchange.model.dto.TelephoneExchangeExtendedDTO;
import com.pvlstkv.telephone_exchange.service.TelephoneExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telephone-exchanges")
@AllArgsConstructor
public class TelephoneExchangeController {
    private TelephoneExchangeService service;

    private TelephoneExchangeMapper exchangeMapper;

    @GetMapping("/{id}")
    public TelephoneExchangeDTO getTelephoneExchange(@PathVariable Long id) {
        return exchangeMapper.toDTO(service.getTelephoneExchange(id));
    }
    @GetMapping("/all-extended")
    public List<TelephoneExchangeExtendedDTO> getAllExtendedTelephoneExchanges(){
        return exchangeMapper.toExtendedDTOList(service.getAllTelephoneExchanges());
    }
    @GetMapping
    public List<TelephoneExchangeDTO> getAllTelephoneExchanges()
    {
        return exchangeMapper.toDTOList(service.getAllTelephoneExchanges());
    }    @PostMapping
    public TelephoneExchangeDTO createTelephoneExchange(@RequestBody TelephoneExchangeDTO dto) {
        return exchangeMapper.toDTO(service.createTelephoneExchange(exchangeMapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public TelephoneExchangeDTO updateTelephoneExchange(@PathVariable Long id, @RequestBody TelephoneExchangeDTO dto) {
        return exchangeMapper.toDTO(service.updateTelephoneExchange(id, exchangeMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void deleteTelephoneExchange(@PathVariable Long id) {
        service.deleteTelephoneExchange(id);
    }
}
