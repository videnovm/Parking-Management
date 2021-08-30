package com.videnovm.parkingmanagement.repository;

import com.videnovm.parkingmanagement.model.EntranceExitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EntranceExitLogRepository extends JpaRepository<EntranceExitLog, Long> {

    @Modifying
    @Transactional
    void deleteByVehicleId(Long vehicleId);
}
