package com.attendance.Controller;

import com.attendance.Model.Standard;
import com.attendance.Service.StandardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/standards")
@CrossOrigin(origins = "http://localhost:3000")
public class StandardController {
    private final StandardService standardService;

    public StandardController(StandardService standardService) {
        this.standardService = standardService;
    }

    @PostMapping
    public ResponseEntity<Standard>addStandard(@RequestBody Standard standard){
        return ResponseEntity.ok(standardService.addStandard(standard));
    }

    @GetMapping
    public ResponseEntity<List<Standard>> getAllStandards() {
        return ResponseEntity.ok(standardService.getAllStandards());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Standard> editStandard(@PathVariable int id, @RequestBody Standard standard) {
        return ResponseEntity.ok(standardService.editStandard(id, standard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStandard(@PathVariable int id) {
        return ResponseEntity.ok(standardService.deleteStandard(id));
    }
}
