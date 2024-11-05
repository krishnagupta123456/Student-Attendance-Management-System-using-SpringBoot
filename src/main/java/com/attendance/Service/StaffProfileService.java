package com.attendance.Service;

import com.attendance.Model.StaffProfile;
import com.attendance.Model.Standard;
import com.attendance.Model.User;
import com.attendance.Repository.StaffProfileRepository;
import com.attendance.Repository.StandardRepository;
import com.attendance.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffProfileService {
    private final StaffProfileRepository staffProfileRepository;
    private final UserRepository userRepository;
    private final StandardRepository standardRepository;

    public StaffProfileService(StaffProfileRepository staffProfileRepository, UserRepository userRepository, StandardRepository standardRepository) {
        this.staffProfileRepository = staffProfileRepository;
        this.userRepository = userRepository;
        this.standardRepository = standardRepository;
    }

    public StaffProfile createOrUpdateStaffProfile(int userId, int standardId, StaffProfile staffProfile) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User not found");
        }
        Optional<Standard> optionalStandard = standardRepository.findById(standardId);
        Standard standard = optionalStandard.get();
        if(!optionalStandard.isPresent()){
            throw new RuntimeException("Standard not found");
        }

        StaffProfile existingProfile = staffProfileRepository.findByUserId(userId);

        if (existingProfile != null) {
            existingProfile.setStaffName(staffProfile.getStaffName());
            existingProfile.setMobile(staffProfile.getMobile());
            existingProfile.setAddress(staffProfile.getAddress());
            existingProfile.setQualification(staffProfile.getQualification());
            existingProfile.setCity(staffProfile.getCity());
            existingProfile.setGender(staffProfile.getGender());
            existingProfile.setPincode(staffProfile.getPincode());
            existingProfile.setPhoto(staffProfile.getPhoto());

            return staffProfileRepository.save(existingProfile);
        } else {
            staffProfile.setUser(user);
            staffProfile.setStandard(standard);
            return staffProfileRepository.save(staffProfile);
        }
    }

    public StaffProfile getStaffProfile(int userId,int standardId){
        StaffProfile staffProfiles=staffProfileRepository.findByUserId(userId);
        StaffProfile staffProfile=staffProfileRepository.findByStandardId(standardId);
        return  staffProfile;
    }


}
