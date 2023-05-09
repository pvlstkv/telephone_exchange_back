package com.pvlstkv.telephone_exchange.controller;

import com.pvlstkv.telephone_exchange.mapper.PhoneNumberMapper;
import com.pvlstkv.telephone_exchange.model.dto.PhoneNumberDTO;
import com.pvlstkv.telephone_exchange.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone-numbers")
public class PhoneNumberController {
    @Autowired
    private PhoneNumberService phoneNumberService;

    private PhoneNumberMapper numberMapper;

    @GetMapping("/{id}")
    public PhoneNumberDTO getPhoneNumber(@PathVariable Long id) {
        return numberMapper.toDto(phoneNumberService.getPhoneNumber(id));
    }

    @PostMapping
    public PhoneNumberDTO createPhoneNumber(@RequestBody PhoneNumberDTO dto) {
        return numberMapper.toDto(phoneNumberService.createPhoneNumber(
                numberMapper.toEntity(dto)
        ));
    }

    @PutMapping("/{id}")
    public PhoneNumberDTO updatePhoneNumber(@PathVariable Long id, @RequestBody PhoneNumberDTO dto) {
        return numberMapper.toDto(phoneNumberService.updatePhoneNumber(id, dto));
    }

    @DeleteMapping("/{id}")
    public void deletePhoneNumber(@PathVariable Long id) {
        phoneNumberService.deletePhoneNumber(id);
    }
}