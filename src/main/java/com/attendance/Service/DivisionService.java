package com.attendance.Service;

import com.attendance.DTO.DivisionDTO;
import com.attendance.Model.Division;
import com.attendance.Model.Standard;
import com.attendance.Repository.DivisionRepository;
import com.attendance.Repository.StandardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DivisionService {
    private final DivisionRepository divisionRepository;
    private final StandardRepository standardRepository;

    public DivisionService(DivisionRepository divisionRepository, StandardRepository standardRepository) {
        this.divisionRepository = divisionRepository;
        this.standardRepository = standardRepository;
    }

    public DivisionDTO addDivision(DivisionDTO divisionDto) {
        Standard standard = standardRepository.findByStdName(divisionDto.getStandard());
        Division division = new Division();
        division.setDivName(divisionDto.getDivName());
        division.setSeat(divisionDto.getSeat());
        division.setStandard(standard);
        divisionRepository.save(division);
        divisionDto.setId(division.getId());
        return divisionDto;
    }
    public List<DivisionDTO> getAllDivisions() {
        List<Division> divisions = divisionRepository.findAll();

        return divisions.stream().map(division -> {
            DivisionDTO dto = new DivisionDTO();
            dto.setId(division.getId());
            dto.setDivName(division.getDivName());
            dto.setSeat(division.getSeat());
            dto.setStandard(division.getStandard() != null ? division.getStandard().getStdName() : "Unknown Standardtf");
            return dto;
        }).collect(Collectors.toList());
    }

    public DivisionDTO getDivisionById(int id) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Division not found with ID: " + id));
        DivisionDTO dto1 = new DivisionDTO();
        dto1.setId(division.getId());
        dto1.setDivName(division.getDivName());
        dto1.setSeat(division.getSeat());
        dto1.setStandard(division.getStandard() != null ? division.getStandard().getStdName() : "Unknown Standard");
        return dto1;
    }


    public DivisionDTO editDivision(int id, DivisionDTO divisionDto) {
        Division existingDivision = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Division not found with ID: " + id));

        Standard standard = standardRepository.findByStdName(divisionDto.getStandard());
        if (standard == null) {
            throw new RuntimeException("Standard not found with name: " + divisionDto.getStandard());
        }
        existingDivision.setDivName(divisionDto.getDivName());
        existingDivision.setSeat(divisionDto.getSeat());
        existingDivision.setStandard(standard);
        existingDivision = divisionRepository.save(existingDivision);
        divisionDto.setId(existingDivision.getId());
        return divisionDto;
    }

    public boolean deleteDivision(int id) {
        if (divisionRepository.existsById(id)) {
            divisionRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
