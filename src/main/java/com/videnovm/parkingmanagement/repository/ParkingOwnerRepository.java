package com.videnovm.parkingmanagement.repository;

import com.videnovm.parkingmanagement.model.ParkingOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingOwnerRepository extends JpaRepository<ParkingOwner, Long> {
}
