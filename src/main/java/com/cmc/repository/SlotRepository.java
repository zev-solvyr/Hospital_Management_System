package com.cmc.repository;

import com.cmc.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot,Long> {

    List<Slot> findByDoctorDoctorId(Long doctorId);
    // 2. Check overlapping slots (OPTIMIZED)
    @Query("""
        SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END
        FROM Slot s
        WHERE s.doctor.doctorId = :doctorId
        AND (:startTime < s.endTime AND :endTime > s.startTime)
    """)
    boolean existsOverlappingSlot(Long doctorId,
                                  LocalDateTime startTime,
                                  LocalDateTime endTime);

}
