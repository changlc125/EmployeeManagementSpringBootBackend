package com.example.housingservice.controller;

import com.example.housingservice.domain.Facility;
import com.example.housingservice.domain.request.FacilityRequest;
import com.example.housingservice.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityController {
    private FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping
    public List<Facility> getAllFacility() {
        return facilityService.getAllFacility();
    }

    @GetMapping("/{id}")
    public Facility getFacilityById(@PathVariable int id) {
        return facilityService.getFacilityById(id);
    }

    @PostMapping
    public String createNewFacility(@RequestBody FacilityRequest request, @RequestParam int houseId) {
        return facilityService.createNewFacility(request, houseId);
    }
}
