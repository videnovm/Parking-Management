package com.videnovm.parkingmanagement.service;

import com.videnovm.parkingmanagement.model.Parking;

import java.util.List;

public interface ParkingService {
    List<Parking> getParkings();
    Parking createParking(Parking parking);
}
