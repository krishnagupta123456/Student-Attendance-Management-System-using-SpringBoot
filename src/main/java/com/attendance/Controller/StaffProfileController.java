package com.attendance.Controller;

import com.attendance.Model.StaffProfile;
import com.attendance.Service.StaffProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staffprofile")
public class StaffProfileController {
    private final StaffProfileService staffProfileService;

    public StaffProfileController(StaffProfileService staffProfileService) {
        this.staffProfileService = staffProfileService;
    }

    @PostMapping("/{userId}/{standardId}")
    public ResponseEntity<StaffProfile> createOrUpdateStaffProfile(
            @PathVariable int userId,
            @PathVariable int standardId,
            @RequestBody StaffProfile staffProfile) {
        StaffProfile updatedProfile = staffProfileService.createOrUpdateStaffProfile(userId, standardId, staffProfile);
        return ResponseEntity.ok(updatedProfile);
    }

    @GetMapping("/{userId}/{standardId}")
    public ResponseEntity<StaffProfile> getStaffProfile(
            @PathVariable int userId,
            @PathVariable int standardId) {
        StaffProfile staffProfile = staffProfileService.getStaffProfile(userId, standardId);
        return ResponseEntity.ok(staffProfile);
    }
}
