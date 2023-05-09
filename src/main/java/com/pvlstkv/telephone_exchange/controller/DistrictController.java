package com.pvlstkv.telephone_exchange.controller;

import com.pvlstkv.telephone_exchange.mapper.DistrictMapper;
import com.pvlstkv.telephone_exchange.model.District;
import com.pvlstkv.telephone_exchange.model.dto.DistrictDTO;
import com.pvlstkv.telephone_exchange.service.CityService;
import com.pvlstkv.telephone_exchange.service.DistrictService;
import com.pvlstkv.telephone_exchange.service.TelephoneExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/districts")
@RequiredArgsConstructor
public class DistrictController {

    private DistrictService districtService;


    private CityService cityService;

    private DistrictMapper districtMapper;

    private TelephoneExchangeService exchangeService;

    @PostMapping
    public DistrictDTO createDistrict(@RequestBody DistrictDTO dto) {
        District district = districtMapper.toEntity(dto, cityService.getCity(dto.getCityId()), exchangeService.findAllById(dto.getExchangeIds()));
        return districtMapper.toDTO(districtService.save(district));
    }

    @GetMapping("/{id}")
    public DistrictDTO getDistrict(@PathVariable Long id) {
        return districtMapper.toDTO(districtService.findById(id));
    }

    @PutMapping("/{id}")
    public DistrictDTO updateDistrict(@PathVariable Long id, @RequestBody DistrictDTO dto) {
        District district = districtMapper.toEntity(dto, cityService.getCity(dto.getCityId()), exchangeService.findAllById(dto.getExchangeIds()));
        district.setId(id);
        return districtMapper.toDTO(districtService.save(district));
    }

    @DeleteMapping("/{id}")
    public void deleteDistrict(@PathVariable Long id) {
        districtService.deleteById(id);
    }
}
