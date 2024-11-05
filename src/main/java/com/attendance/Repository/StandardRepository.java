package com.attendance.Repository;

import com.attendance.Model.Standard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StandardRepository extends JpaRepository<Standard, Integer> {
    Standard findByStdName(String stdName);
}
