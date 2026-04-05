package com.cmc.repository;

import com.cmc.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    boolean existsByEmail(String emailId);
}
