package com.attendance.Controller;

import com.attendance.DTO.DivisionDTO;
import com.attendance.Service.DivisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/divisions")
@CrossOrigin(origins = "http://localhost:3000")
public class DivisionController {

    private final DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @PostMapping
    public ResponseEntity<DivisionDTO> addDivision(@RequestBody DivisionDTO divisionDto) {
        return ResponseEntity.ok(divisionService.addDivision(divisionDto));
    }
    @GetMapping
    public ResponseEntity<List<DivisionDTO>> getAllDivisions() {
        List<DivisionDTO> divisions = divisionService.getAllDivisions();
        return ResponseEntity.ok(divisions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DivisionDTO> editDivision(@PathVariable int id, @RequestBody DivisionDTO division) {
        return ResponseEntity.ok(divisionService.editDivision(id, division));
    }

    @GetMapping("/{id}")
    public DivisionDTO getDivisionById(@PathVariable int id) {
        return divisionService.getDivisionById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDivision(@PathVariable int id) {
        return ResponseEntity.ok(divisionService.deleteDivision(id));
    }

}
