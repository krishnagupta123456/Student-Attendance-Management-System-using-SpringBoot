package com.attendance.Repository;

import com.attendance.Model.StaffProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffProfileRepository extends JpaRepository<StaffProfile, Integer> {
    StaffProfile findByUserId(int userId);
    StaffProfile findByStandardId(int standardId);
}
