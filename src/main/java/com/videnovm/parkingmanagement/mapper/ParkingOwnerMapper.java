package com.videnovm.parkingmanagement.mapper;

import com.videnovm.parkingmanagement.dto.ParkingOwnerDto;
import com.videnovm.parkingmanagement.model.ParkingOwner;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParkingOwnerMapper {

    @IterableMapping(qualifiedByName = "toParkingOwnerDto")
    List<ParkingOwnerDto> toParkingOwnerDtos(List<ParkingOwner> parkingOwners);

    @Named("toParkingOwnerDto")
    ParkingOwnerDto toParkingOwnerDto(ParkingOwner parkingOwner);

    @Named("toParkingOwner")
    ParkingOwner toParkingOwner(ParkingOwnerDto parkingOwnerDto);

}
