package com.videnovm.parkingmanagement.mapper;

import com.videnovm.parkingmanagement.dto.EntranceExitLogDto;
import com.videnovm.parkingmanagement.model.EntranceExitLog;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntranceExitLogMapper {

    @IterableMapping(qualifiedByName = "toEntranceExitLogDto")
    List<EntranceExitLogDto> toEntranceExitLogDtos(List<EntranceExitLog> entranceExitLogs);

    @Named("toEntranceExitLog")
    EntranceExitLog toEntranceExitLog(EntranceExitLogDto entranceExitLogDto);

    @Named("toEntranceExitLogDto")
    EntranceExitLogDto toEntranceExitLogDto(EntranceExitLog entranceExitLog);
}
