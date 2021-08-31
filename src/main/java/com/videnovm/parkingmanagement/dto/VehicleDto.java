package com.videnovm.parkingmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {

    private Long id;

    private String vehicleType;

    private String licensePlate;

    private Long userId;

    private Long parkingId;

}
