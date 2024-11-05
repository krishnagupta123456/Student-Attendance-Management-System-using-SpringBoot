package com.attendance.Service;

import com.attendance.Model.AdminProfile;
import com.attendance.Model.User;
import com.attendance.Repository.AdminProfileRepository;
import com.attendance.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminProfileService {
    private final AdminProfileRepository adminProfileRepository;
    private final UserRepository userRepository;

    public AdminProfileService(AdminProfileRepository adminProfileRepository, UserRepository userRepository) {
        this.adminProfileRepository = adminProfileRepository;
        this.userRepository = userRepository;
    }

    public AdminProfile createOrUpdateAdminProfile(int userId, AdminProfile adminProfile) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User not found");
        }


        AdminProfile existingProfile = adminProfileRepository.findByUserId(userId);

        if (existingProfile != null) {
            existingProfile.setName(adminProfile.getName());
            return adminProfileRepository.save(existingProfile);
        } else {
            adminProfile.setUser(user);
            return adminProfileRepository.save(adminProfile);
        }
    }

    public AdminProfile getAdminProfile(int userId){
        AdminProfile adminProfile=adminProfileRepository.findByUserId(userId);
        return  adminProfile;
    }
}
