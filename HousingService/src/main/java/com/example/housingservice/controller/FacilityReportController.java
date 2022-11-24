package com.example.housingservice.controller;

import com.example.housingservice.domain.FacilityReport;
import com.example.housingservice.domain.request.FacilityReportRequest;
import com.example.housingservice.service.FacilityReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facility-reports")
public class FacilityReportController {
    private FacilityReportService facilityReportService;

    @Autowired
    public FacilityReportController(FacilityReportService facilityReportService) {
        this.facilityReportService = facilityReportService;
    }

    @GetMapping
    public List<FacilityReport> getAllFacilityReport() {
        return facilityReportService.getAllFacilityReport();
    }

    @GetMapping("/{id}")
    public FacilityReport getFacilityReportById(@PathVariable int id) {
        return facilityReportService.getFacilityReportById(id);
    }

    @PostMapping
    public String createNewFacilityReport(@RequestBody FacilityReportRequest request, @RequestParam String employeeId, @RequestParam int facilityId) {
        return facilityReportService.createNewFacilityReport(request, employeeId, facilityId);
    }
}
