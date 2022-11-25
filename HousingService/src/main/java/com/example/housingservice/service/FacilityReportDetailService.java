package com.example.housingservice.service;

import com.example.housingservice.domain.FacilityReport;
import com.example.housingservice.domain.FacilityReportDetail;
import com.example.housingservice.domain.request.FacilityReportDetailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityReportDetailService {
    private FacilityReportDetailDao facilityReportDetailDao;
    private FacilityReportService facilityReportService;

    @Autowired
    public FacilityReportDetailService(FacilityReportDetailDao facilityReportDetailDao, FacilityReportService facilityReportService) {
        this.facilityReportDetailDao = facilityReportDetailDao;
        this.facilityReportService = facilityReportService;
    }

    public List<FacilityReportDetail> getAllFacilityReportDetail() {
        return facilityReportDetailDao.getAllFacilityReportDetail();
    }

    public FacilityReportDetail getFacilityReportDetailById(int id) {
        return facilityReportDetailDao.getFacilityReportDetailById(id);
    }

    public String createNewFacilityReportDetail(FacilityReportDetailRequest request, String employeeId, int facilityReportId) {
        FacilityReport facilityReport = facilityReportService.getFacilityReportById(facilityReportId);
        if(facilityReport == null){return "Facility Report doesn't exist";}

        FacilityReportDetail facilityReportDetail = FacilityReportDetail.builder()
                .facilityReport(facilityReport)
                .employeeId(employeeId)
                .comment(request.getComment())
                .createDate(request.getCreateDate())
                .lastModificationDate(request.getLastModificationDate())
                .build();

        if (facilityReportDetailDao.createNewFacilityReportDetail(facilityReportDetail)) {
            return "Facility Report Detail is added";
        }
        return "Facility Report Detail is already existed";
    }
}
