package com.example.housingservice.service;

import com.example.housingservice.domain.Facility;
import com.example.housingservice.domain.FacilityReport;
import com.example.housingservice.domain.request.FacilityReportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityReportService {
    private FacilityReportDao facilityReportDao;
    private FacilityService facilityService;

    @Autowired
    public FacilityReportService(FacilityReportDao facilityReportDao, FacilityService facilityService) {
        this.facilityReportDao = facilityReportDao;
        this.facilityService = facilityService;
    }

    public List<FacilityReport> getAllFacilityReport() {
        return facilityReportDao.getAllFacilityReport();
    }

    public FacilityReport getFacilityReportById(int id) {
        return facilityReportDao.getFacilityReportById(id);
    }

    public String createNewFacilityReport(FacilityReportRequest request, String employeeId, int facilityId) {
        Facility facility = facilityService.getFacilityById(facilityId);

        if(facility == null){return "Facility doesn't exist";}

        FacilityReport facilityReport = FacilityReport.builder()
                .facility(facility)
                .employeeId(employeeId)
                .title(request.getTitle())
                .description(request.getDescription())
                .createDate(request.getCreateDate())
                .status(request.getStatus())
                .build();

        if (facilityReportDao.createNewFacilityReport(facilityReport)) {
            return "Facility Report is added";
        }
        return "Facility Report is already existed";
    }
}
