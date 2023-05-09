package com.pvlstkv.telephone_exchange.controller;

import com.pvlstkv.telephone_exchange.mapper.CityMapper;
import com.pvlstkv.telephone_exchange.model.City;
import com.pvlstkv.telephone_exchange.model.dto.CityDTO;
import com.pvlstkv.telephone_exchange.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityController {
    private CityService cityService;

    private CityMapper cityMapper;

    @GetMapping("/{id}")
    public CityDTO getCity(@PathVariable Long id) {
        City city = cityService.getCity(id);
        return cityMapper.toDTO(city);
    }

    @PostMapping
    public CityDTO createCity(@RequestBody CityDTO dto) {
        City city = cityMapper.toEntity(dto);
        city = cityService.createCity(city);
        return cityMapper.toDTO(city);
    }

    @PutMapping("/{id}")
    public CityDTO updateCity(@PathVariable Long id, @RequestBody CityDTO dto) {
        City city = cityService.updateCity(id, cityMapper.toEntity(dto));
        return cityMapper.toDTO(city);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}