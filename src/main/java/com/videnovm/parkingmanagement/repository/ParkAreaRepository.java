package com.videnovm.parkingmanagement.repository;

import com.videnovm.parkingmanagement.model.ParkArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkAreaRepository extends JpaRepository<ParkArea, Long> {
}
