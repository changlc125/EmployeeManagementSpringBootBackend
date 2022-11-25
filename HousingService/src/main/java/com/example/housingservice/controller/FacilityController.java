package com.example.housingservice.controller;

import com.example.housingservice.domain.Facility;
import com.example.housingservice.domain.request.FacilityRequest;
import com.example.housingservice.service.FacilityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
@Api(value = "facilities RESTful endpoints")
public class FacilityController {
    private FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping
    @ApiOperation(value = "Find all facilities", response = Iterable.class)
    public List<Facility> getAllFacility() {
        return facilityService.getAllFacility();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find a facility by ID", response = Facility.class)
    public Facility getFacilityById(@PathVariable int id) {
        return facilityService.getFacilityById(id);
    }

    @PostMapping
    @ApiOperation(value = "Create a facility ", response = String.class)
    public String createNewFacility(@RequestBody FacilityRequest request, @RequestParam int houseId) {
        return facilityService.createNewFacility(request, houseId);
    }
}
