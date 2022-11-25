package com.example.housingservice.controller;

import com.example.housingservice.domain.Landlord;
import com.example.housingservice.domain.request.LandlordRequest;
import com.example.housingservice.service.LandlordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/landlords")
@Api(value = "Landlord RESTful endpoints")
public class LandlordController {
    private LandlordService landlordService;

    @Autowired
    public LandlordController(LandlordService landlordService) {
        this.landlordService = landlordService;
    }

    @GetMapping
    @ApiOperation(value = "Find all landlords", response = Iterable.class)
    public List<Landlord> getAllLandlord() {
        return landlordService.getAllLandlord();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find a landlord by ID", response = Landlord.class)
    public Landlord getLandlordById(@PathVariable int id) {
        return landlordService.getLandlordById(id);
    }

    @PostMapping
    @ApiOperation(value = "Create a landlord")
    public String createNewLandlord(@RequestBody LandlordRequest request) {
        return landlordService.createNewLandlord(request);
    }
}
