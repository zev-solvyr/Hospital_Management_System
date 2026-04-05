package com.cmc.repository;

import com.cmc.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    boolean existsBySlotSlotId(Long slotId);
    List<Appointment> findByPatientPatientId(Long patientId);
}
