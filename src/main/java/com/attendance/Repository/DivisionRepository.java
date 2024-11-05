package com.attendance.Repository;

import com.attendance.Model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division,Integer> {
    Division findByDivName(String divname);
}
