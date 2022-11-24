package com.example.housingservice.controller;

import com.example.housingservice.domain.Landlord;
import com.example.housingservice.domain.request.LandlordRequest;
import com.example.housingservice.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/landlords")
public class LandlordController {
    private LandlordService landlordService;

    @Autowired
    public LandlordController(LandlordService landlordService) {
        this.landlordService = landlordService;
    }

    @GetMapping
    public List<Landlord> getAllLandlord() {
        return landlordService.getAllLandlord();
    }

    @GetMapping("/{id}")
    public Landlord getLandlordById(@PathVariable int id) {
        return landlordService.getLandlordById(id);
    }

    @PostMapping
    public String createNewLandlord(@RequestBody LandlordRequest request) {
        return landlordService.createNewLandlord(request);
    }
}
