package com.attendance.Service;

import com.attendance.Model.Standard;
import com.attendance.Repository.StandardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardService {
    private final StandardRepository standardRepository;

    public StandardService(StandardRepository standardRepository) {
        this.standardRepository = standardRepository;
    }

    public Standard addStandard(Standard standard){
        return standardRepository.save(standard);
    }

    public List<Standard> getAllStandards() {
        return standardRepository.findAll();
    }

    public Standard editStandard(int id, Standard standard){
        Standard existingStandard = standardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Standard not found"));

        existingStandard.setStdName(standard.getStdName());
        return standardRepository.save(existingStandard);
    }
    public boolean deleteStandard(int id) {
        if (standardRepository.existsById(id)) {
            standardRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
