package com.attendance.Controller;

import com.attendance.Model.StudentProfile;
import com.attendance.Service.StudentProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentprofile")
public class StudentProfileController {
    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @PostMapping("/{userId}/{standardId}/{divisionId}")
    public ResponseEntity<StudentProfile> createOrUpdateStudentProfile(
            @PathVariable int userId,
            @PathVariable int standardId,
            @PathVariable int divisionId,
            @RequestBody StudentProfile studentProfile) {
        StudentProfile updatedProfile = studentProfileService.createOrUpdateStudentProfile(userId, standardId,divisionId, studentProfile);
        return ResponseEntity.ok(updatedProfile);
    }

    @GetMapping("/{userId}/{standardId}/{divisionId}")
    public ResponseEntity<StudentProfile> getStudentProfile(
            @PathVariable int userId,
            @PathVariable int standardId,
            @PathVariable int divisionId
    ) {
        StudentProfile studentProfile = studentProfileService.getStudentProfile(userId, standardId,divisionId);
        return ResponseEntity.ok(studentProfile);
    }
}
