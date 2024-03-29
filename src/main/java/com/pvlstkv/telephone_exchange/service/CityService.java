package com.pvlstkv.telephone_exchange.service;

import com.pvlstkv.telephone_exchange.model.City;
import com.pvlstkv.telephone_exchange.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@AllArgsConstructor
@Service
public class CityService {

    private CityRepository cityRepository;

    public List<City> getCities(List<Long> ids) {
        return cityRepository.findAllById(ids);
    }

    public City getCity(Long id){
        return cityRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found with id = " + id));
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City city) {
        City entity = cityRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found with id = " + id));
        entity.setName(city.getName());
        entity.setDistricts(city.getDistricts());
        return cityRepository.save(entity);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
