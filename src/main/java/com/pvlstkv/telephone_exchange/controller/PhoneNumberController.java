package com.pvlstkv.telephone_exchange.controller;

import com.pvlstkv.telephone_exchange.mapper.PhoneNumberMapper;
import com.pvlstkv.telephone_exchange.model.dto.PhoneNumberDTO;
import com.pvlstkv.telephone_exchange.model.dto.PhoneNumberExtendedDTO;
import com.pvlstkv.telephone_exchange.service.PhoneNumberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone-numbers")
@AllArgsConstructor
public class PhoneNumberController {
    private PhoneNumberService phoneNumberService;

    private PhoneNumberMapper numberMapper;

    @GetMapping("/{ids}")
    public List<PhoneNumberDTO> getPhoneNumber(@PathVariable List<Long> ids) {
        return numberMapper.toDTOList(phoneNumberService.getPhoneNumber(ids));
    }

    @GetMapping("/all-extended")
    public List<PhoneNumberExtendedDTO> getAllExtendedNumbers(){
        return numberMapper.toExtendedDTOList(phoneNumberService.getAllPhoneNumbers());
    }
    @GetMapping
    public List<PhoneNumberDTO> getAllPhoneNumber() {
        return numberMapper.toDTOList(phoneNumberService.getAllPhoneNumbers());
    }

    @PostMapping
    public PhoneNumberDTO createPhoneNumber(@RequestBody PhoneNumberDTO dto) {
        return numberMapper.toDTO(phoneNumberService.createPhoneNumber(
                numberMapper.toEntity(dto)
        ));
    }

    @PutMapping("/{id}")
    public PhoneNumberDTO updatePhoneNumber(@PathVariable Long id, @RequestBody PhoneNumberDTO dto) {
        return numberMapper.toDTO(phoneNumberService.updatePhoneNumber(id, numberMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void deletePhoneNumber(@PathVariable Long id) {
        phoneNumberService.deletePhoneNumber(id);
    }
}