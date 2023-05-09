package com.pvlstkv.telephone_exchange.controller;

import com.pvlstkv.telephone_exchange.mapper.DistrictMapper;
import com.pvlstkv.telephone_exchange.model.District;
import com.pvlstkv.telephone_exchange.model.dto.DistrictDTO;
import com.pvlstkv.telephone_exchange.service.CityService;
import com.pvlstkv.telephone_exchange.service.DistrictService;
import com.pvlstkv.telephone_exchange.service.TelephoneExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/districts")
@AllArgsConstructor
public class DistrictController {

    private DistrictService districtService;


    private CityService cityService;

    private DistrictMapper districtMapper;

    private TelephoneExchangeService exchangeService;

    @PostMapping
    public DistrictDTO createDistrict(@RequestBody DistrictDTO dto) {
        District district = districtMapper.toEntity(dto, cityService.getCity(dto.getCityId()),
                exchangeService.getAllTelephoneExchange(dto.getExchangeIds()));
        return districtMapper.toDTO(districtService.createDistrict(district));
    }

    @GetMapping("/{id}")
    public DistrictDTO getDistrict(@PathVariable Long id) {
        return districtMapper.toDTO(districtService.getDistrict(id));
    }

    @PutMapping("/{id}")
    public DistrictDTO updateDistrict(@PathVariable Long id, @RequestBody DistrictDTO dto) {
        District district = districtMapper.toEntity(dto, cityService.getCity(dto.getCityId()),
                exchangeService.getAllTelephoneExchange(dto.getExchangeIds()));
        return districtMapper.toDTO(districtService.updateDistrict(id, district));
    }

    @DeleteMapping("/{id}")
    public void deleteDistrict(@PathVariable Long id) {
        districtService.deleteDistrict(id);
    }
}
