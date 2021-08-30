package com.videnovm.parkingmanagement.service;

import com.videnovm.parkingmanagement.model.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getVehicles();
    Vehicle createVehicle(Vehicle vehicle);
    void deleteVehicle(Long id);
}
