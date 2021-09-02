package com.videnovm.parkingmanagement.controller;

import com.videnovm.parkingmanagement.dto.ParkingOwnerDto;
import com.videnovm.parkingmanagement.mapper.ParkingOwnerMapper;
import com.videnovm.parkingmanagement.model.ParkingOwner;
import com.videnovm.parkingmanagement.service.ParkingOwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@Api(value = "ParkingOwner Controller")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "https://parkingapps.herokuapp.com/"})
public class ParkingOwnerController {

    @Autowired
    private final ParkingOwnerService parkingOwnerService;

    private final ParkingOwnerMapper parkingOwnerMapper;

    @ApiOperation(value = "Get all parking owners", notes = "Returns all parking owners")
    @GetMapping("/parking_owner")
    public ResponseEntity<List<ParkingOwnerDto>> getParkingOwners(){
        return ResponseEntity.ok(parkingOwnerMapper.toParkingOwnerDtos(parkingOwnerService.getParkingOwners()));
    }

    @ApiOperation(value = "Create an owner", notes ="Creates an owner and returns it")
    @PostMapping("/parking_owner")
    public ResponseEntity<ParkingOwnerDto> createParking(@RequestBody ParkingOwnerDto parkingOwnerDto){
        try{
            parkingOwnerDto.setPassword(new String(Base64.getEncoder().encodeToString(parkingOwnerDto.getPassword().getBytes())));
            ParkingOwner createdParkingOwner = parkingOwnerService.createParkingOwner(parkingOwnerMapper.toParkingOwner(parkingOwnerDto));
            parkingOwnerService.createParkingOwner(createdParkingOwner);
            return ResponseEntity.ok(parkingOwnerMapper.toParkingOwnerDto(createdParkingOwner));
        } catch (ConstraintViolationException ex) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
