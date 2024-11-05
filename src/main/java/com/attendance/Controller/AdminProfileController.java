package com.attendance.Controller;

import com.attendance.Model.AdminProfile;
import com.attendance.Service.AdminProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminProfileController {
    private final AdminProfileService adminProfileService;

    public AdminProfileController(AdminProfileService adminProfileService) {
        this.adminProfileService = adminProfileService;
    }

    @PostMapping("adminprofile/{userId}")
    public ResponseEntity<AdminProfile> createOrUpdateAdminProfile(
            @PathVariable int userId,
            @RequestBody AdminProfile adminProfile) {
        AdminProfile updatedProfile = adminProfileService.createOrUpdateAdminProfile(userId, adminProfile);
        return ResponseEntity.ok(updatedProfile);
    }


    @GetMapping("adminprofile/{userId}")
    public ResponseEntity<AdminProfile> getAdminProfile(@PathVariable int userId){
        AdminProfile adminProfile=adminProfileService.getAdminProfile(userId);
        return ResponseEntity.ok(adminProfile);
    }
}
