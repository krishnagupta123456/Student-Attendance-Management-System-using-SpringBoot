package com.attendance.Service;

import com.attendance.Model.*;
import com.attendance.Repository.DivisionRepository;
import com.attendance.Repository.StandardRepository;
import com.attendance.Repository.StudentProfileRepository;
import com.attendance.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentProfileService {
    private final StudentProfileRepository studentProfileRepository;
    private final UserRepository userRepository;
    private final StandardRepository standardRepository;
    private final DivisionRepository divisionRepository;

    public StudentProfileService(StudentProfileRepository studentProfileRepository, UserRepository userRepository, StandardRepository standardRepository, DivisionRepository divisionRepository) {
        this.studentProfileRepository = studentProfileRepository;
        this.userRepository = userRepository;
        this.standardRepository = standardRepository;
        this.divisionRepository = divisionRepository;
    }

    public StudentProfile createOrUpdateStudentProfile(int userId, int standardId, int divisionId , StudentProfile studentProfile) {
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
        Optional<Division> optionalDivision = divisionRepository.findById(divisionId);
        Division division = optionalDivision.get();
        if(!optionalDivision.isPresent()){
            throw new RuntimeException("Division not found");
        }

        StudentProfile existingProfile = studentProfileRepository.findByUserId(userId);

        if (existingProfile != null) {
            existingProfile.setStudentName(studentProfile.getStudentName());
            existingProfile.setRollNo(studentProfile.getRollNo());
            existingProfile.setMobile(studentProfile.getMobile());
            existingProfile.setEmail(studentProfile.getEmail());
            existingProfile.setDob(studentProfile.getDob());
            existingProfile.setAddress(studentProfile.getAddress());
            existingProfile.setCity(studentProfile.getCity());
            existingProfile.setPincode(studentProfile.getPincode());
            existingProfile.setPhoto(studentProfile.getPhoto());

            return studentProfileRepository.save(existingProfile);
        } else {
            studentProfile.setUser(user);
            studentProfile.setStandard(standard);
            studentProfile.setDivision(division);
            return studentProfileRepository.save(studentProfile);
        }
    }

    public StudentProfile getStudentProfile(int userId,int standardId,int divisionId){
        StudentProfile studentProfile=studentProfileRepository.findByUserId(userId);
        StudentProfile studentProfile1=studentProfileRepository.findByStandardId(standardId);
        StudentProfile studentProfile2=studentProfileRepository.findByDivisionId(divisionId);
        return  studentProfile;
    }




}
