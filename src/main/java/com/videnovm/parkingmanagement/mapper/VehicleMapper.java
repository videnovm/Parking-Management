package com.videnovm.parkingmanagement.mapper;

import com.videnovm.parkingmanagement.dto.VehicleDto;
import com.videnovm.parkingmanagement.model.Vehicle;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @IterableMapping(qualifiedByName = "toVehicleDto")
    List<VehicleDto> toVehicleDtos(List<Vehicle> vehicles);

    @Named("toVehicle")
    Vehicle toVehicle(VehicleDto vehicleDto);

    @Named("toVehicleDto")
    VehicleDto toVehicleDto(Vehicle vehicle);
}
