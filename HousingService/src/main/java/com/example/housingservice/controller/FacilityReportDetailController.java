package com.example.housingservice.controller;

import com.example.housingservice.domain.FacilityReportDetail;
import com.example.housingservice.domain.request.FacilityReportDetailRequest;
import com.example.housingservice.service.FacilityReportDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facility-report-detail")
public class FacilityReportDetailController {
    private FacilityReportDetailService facilityReportDetailService;

    @Autowired
    public FacilityReportDetailController(FacilityReportDetailService facilityReportDetailService) {
        this.facilityReportDetailService = facilityReportDetailService;
    }

    @GetMapping
    public List<FacilityReportDetail> getAllFacilityReportDetail() {
        return facilityReportDetailService.getAllFacilityReportDetail();
    }

    @GetMapping("/{id}")
    public FacilityReportDetail getFacilityReportDetailById(@PathVariable int id) {
        return facilityReportDetailService.getFacilityReportDetailById(id);
    }

    @PostMapping
    public String createNewFacilityReportDetail(@RequestBody FacilityReportDetailRequest request, @RequestParam String employeeId, @RequestParam int facilityReportId) {
        return facilityReportDetailService.createNewFacilityReportDetail(request, employeeId, facilityReportId);
    }
}
