package com.videnovm.parkingmanagement.mapper;

import com.videnovm.parkingmanagement.dto.ReportListDto;
import com.videnovm.parkingmanagement.model.ReportList;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReportListMapper {

    @IterableMapping(qualifiedByName = "toReportListDto")
    List<ReportListDto> toReportListDtos(List<ReportList> reportLists);

    @Named("toReportList")
    ReportList toReportList(ReportListDto reportListDto);

    @Named("toReportListDto")
    ReportListDto toReportListDto(ReportList reportList);
}
