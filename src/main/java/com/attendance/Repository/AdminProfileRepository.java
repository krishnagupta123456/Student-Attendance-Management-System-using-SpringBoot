package com.attendance.Repository;

import com.attendance.Model.AdminProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminProfileRepository extends JpaRepository<AdminProfile, Integer> {
    AdminProfile findByUserId(int userId);
}
