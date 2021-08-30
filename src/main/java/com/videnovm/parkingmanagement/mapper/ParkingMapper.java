package com.videnovm.parkingmanagement.mapper;


import com.videnovm.parkingmanagement.dto.ParkingDto;
import com.videnovm.parkingmanagement.model.Parking;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParkingMapper {

    @IterableMapping(qualifiedByName = "toParkingDto")
    List<ParkingDto> toParkingDtos(List<Parking> parkings);

    @Named("toParkingDto")
    ParkingDto toParkingDto(Parking parking);

    @Named("toParking")
    Parking toParking(ParkingDto parkingDto);
}
