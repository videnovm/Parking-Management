package com.videnovm.parkingmanagement.service;

import com.videnovm.parkingmanagement.model.ParkingOwner;

import java.util.List;

public interface ParkingOwnerService {
    List<ParkingOwner> getParkingOwners();
    ParkingOwner createParkingOwner(ParkingOwner parkingOwner);
}
