package com.pvlstkv.telephone_exchange.service;

import com.pvlstkv.telephone_exchange.model.District;
import com.pvlstkv.telephone_exchange.repository.DistrictRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DistrictService {

    private DistrictRepository districtRepository;

    public District save(District district) {
        return districtRepository.save(district);
    }

    public District findById(Long id) {
        return districtRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("District not found"));
    }

    public void deleteById(Long id) {
        districtRepository.deleteById(id);
    }
}
