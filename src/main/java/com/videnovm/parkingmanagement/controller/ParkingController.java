package com.videnovm.parkingmanagement.controller;

import com.videnovm.parkingmanagement.dto.EntranceExitLogDto;
import com.videnovm.parkingmanagement.dto.ParkAreaDto;
import com.videnovm.parkingmanagement.dto.ParkingDto;
import com.videnovm.parkingmanagement.mapper.EntranceExitLogMapper;
import com.videnovm.parkingmanagement.mapper.ParkAreaMapper;
import com.videnovm.parkingmanagement.mapper.ParkingMapper;
import com.videnovm.parkingmanagement.model.EntranceExitLog;
import com.videnovm.parkingmanagement.model.ParkArea;
import com.videnovm.parkingmanagement.model.Parking;
import com.videnovm.parkingmanagement.service.EntranceExitLogService;
import com.videnovm.parkingmanagement.service.ParkAreaService;
import com.videnovm.parkingmanagement.service.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Parking Controller")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class ParkingController {

    @Autowired
    private final ParkingService parkingService;

    @Autowired
    private final ParkAreaService parkAreaService;

    private final ParkingMapper parkingMapper;

    private final ParkAreaMapper parkAreaMapper;

    @Autowired
    private final EntranceExitLogService entranceExitLogService;

    private final EntranceExitLogMapper entranceExitLogMapper;

    @ApiOperation(value = "Get all parkings", notes = "returns all parkings")
    @GetMapping("/parking")
    public ResponseEntity<List<ParkingDto>> getParkings() {
        List<Parking> parkings = parkingService.getParkings();
        return ResponseEntity.ok(parkingMapper.toParkingDtos(parkings));
    }

    @ApiOperation(value = "Create an parking", notes = "Creates an parking and returns it")
    @PostMapping("/parking")
    public ResponseEntity<ParkingDto> createParking(@RequestBody ParkingDto parkingDto) {
        try {
            Parking createdParking = parkingService.createParking(parkingMapper.toParking(parkingDto));
            parkAreaService.createParkArea(createdParking.getParkAreaCount(), createdParking.getId());
            return ResponseEntity.ok(parkingMapper.toParkingDto(createdParking));
        } catch (ConstraintViolationException ex) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "Get all park areas", notes = "returns all park areas")
    @GetMapping("/park_area")
    public ResponseEntity<List<ParkAreaDto>> getParkAreas() {
        List<ParkArea> parkAreas = parkAreaService.getParkAreas();
        return ResponseEntity.ok(parkAreaMapper.toParkAreaDtos(parkAreas));
    }

    @ApiOperation(value = "Update an park area", notes = "Updates an park area")
    @PutMapping("/park_area/{id}")
    public ResponseEntity<?> updateParkArea(@PathVariable("id") Long id, @RequestBody ParkAreaDto parkAreaDto) {
        try {
            parkAreaService.updateParkArea(id, parkAreaMapper.toParkArea(parkAreaDto));
            return new ResponseEntity<>("Park area updated with id: " + id, HttpStatus.OK);
        } catch (ConstraintViolationException ex) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "Get all logs", notes = "returns all entrance exit logs")
    @GetMapping("/entrance_exit_log")
    public ResponseEntity<List<EntranceExitLogDto>> getEntranceExitLogs() {
        List<EntranceExitLog> entranceExitLogs = entranceExitLogService.getEntranceExitLogs();
        return ResponseEntity.ok(entranceExitLogMapper.toEntranceExitLogDtos(entranceExitLogs));
    }

    @ApiOperation(value = "Create an entrance exit log", notes = "Creates an entrance exit log and returns it")
    @PostMapping("/entrance_exit_log")
    public ResponseEntity<EntranceExitLogDto> createEntranceExitLog(@RequestBody EntranceExitLogDto entranceExitLogDto) {
        try {
            EntranceExitLog entranceExitLog = entranceExitLogService.createEntranceExitLog(entranceExitLogMapper.toEntranceExitLog(entranceExitLogDto));
            return ResponseEntity.ok(entranceExitLogMapper.toEntranceExitLogDto(entranceExitLog));
        } catch (ConstraintViolationException ex) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "Update an entrance exit log", notes = "Updates an entrance exit log")
    @PutMapping("/entrance_exit_log/{id}")
    public ResponseEntity<?> updateEntranceExitLog(@PathVariable("id") Long id, @RequestBody EntranceExitLogDto entranceExitLogDto) {
        try {
            entranceExitLogService.updateEntranceExitLog(id, entranceExitLogMapper.toEntranceExitLog(entranceExitLogDto));
            return new ResponseEntity<>("Entrance exit log updated with id: " + id, HttpStatus.OK);
        } catch (ConstraintViolationException ex) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "Delete an entrance exit log", notes = "Deletes an entrance exit log by given id")
    @DeleteMapping("/entrance_exit_log/{vehicleId}")
    public ResponseEntity<?> deleteEntranceExitLog(@PathVariable("vehicleId") Long vehicleId) {
        try {
            entranceExitLogService.deleteEntranceExitLogByVehicleId(vehicleId);
        } catch (ConstraintViolationException ex) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return new ResponseEntity<>("Entrance Exit Logs Successfully deleted by vehicle id: " + vehicleId, HttpStatus.OK);
    }
}
