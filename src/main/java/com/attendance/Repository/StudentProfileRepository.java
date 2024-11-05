package com.attendance.Repository;

import com.attendance.Model.StaffProfile;
import com.attendance.Model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer> {
    StudentProfile findByUserId(int userId);
    StudentProfile findByStandardId(int standardId);
    StudentProfile findByDivisionId(int divisionId);
}
