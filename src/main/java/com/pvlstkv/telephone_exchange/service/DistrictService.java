package com.pvlstkv.telephone_exchange.service;

import com.pvlstkv.telephone_exchange.model.District;
import com.pvlstkv.telephone_exchange.repository.DistrictRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class DistrictService {

    private DistrictRepository districtRepository;

    public District createDistrict(District district) {
        return districtRepository.save(district);
    }
    public District updateDistrict(Long id, District district){
        District entity = districtRepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.BAD_REQUEST, "нет района с id = " + id)
        );
        entity.setCity(district.getCity());
        entity.setName(district.getName());
        entity.setExchanges(district.getExchanges());
        return districtRepository.save(entity);
    }

    public District getDistrict(Long id) {
        return districtRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("District not found"));
    }

    public void deleteDistrict(Long id) {
        districtRepository.deleteById(id);
    }
}
