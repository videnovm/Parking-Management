package com.videnovm.parkingmanagement.repository;

import com.videnovm.parkingmanagement.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
