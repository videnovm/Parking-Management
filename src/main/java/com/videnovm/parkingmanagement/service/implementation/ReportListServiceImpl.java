package com.videnovm.parkingmanagement.service.implementation;

import com.videnovm.parkingmanagement.model.ReportList;
import com.videnovm.parkingmanagement.repository.ReportListRepository;
import com.videnovm.parkingmanagement.service.ReportListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportListServiceImpl implements ReportListService {

    ReportListRepository reportListRepository;

    @Autowired
    public void setReportListRepository(ReportListRepository reportListRepository) {
        this.reportListRepository = reportListRepository;
    }

    @Override
    public List<ReportList> getReportList() {
        return reportListRepository.findAll();
    }

    @Override
    public ReportList createReportListItem(ReportList reportList) {
        return reportListRepository.save(reportList);
    }

    @Override
    public ReportList updateReportListItem(Long id, ReportList reportList) {
        ReportList reportListToUpdate = reportListRepository.getOne(id);
        reportListToUpdate.setActive(reportList.isActive());
        return reportListRepository.save(reportListToUpdate);
    }

    @Override
    public void deleteReportListItemByVehicleId(Long vehicleId) {
        reportListRepository.deleteByVehicleId(vehicleId);
    }
}
