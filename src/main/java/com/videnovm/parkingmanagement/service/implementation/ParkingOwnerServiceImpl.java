package com.videnovm.parkingmanagement.service.implementation;

import com.videnovm.parkingmanagement.model.ParkingOwner;
import com.videnovm.parkingmanagement.repository.ParkingOwnerRepository;
import com.videnovm.parkingmanagement.service.ParkingOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingOwnerServiceImpl implements ParkingOwnerService {

    ParkingOwnerRepository parkingOwnerRepository;

    @Autowired
    public void setParkingOwnerRepository(ParkingOwnerRepository parkingOwnerRepository) {
        this.parkingOwnerRepository = parkingOwnerRepository;
    }

    @Override
    public List<ParkingOwner> getParkingOwners() {
        return parkingOwnerRepository.findAll();
    }

    @Override
    public ParkingOwner createParkingOwner(ParkingOwner parkingOwner) {
        return parkingOwnerRepository.save(parkingOwner);
    }
}
