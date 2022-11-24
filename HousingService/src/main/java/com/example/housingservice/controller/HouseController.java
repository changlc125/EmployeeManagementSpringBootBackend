package com.example.housingservice.controller;

import com.example.housingservice.domain.House;
import com.example.housingservice.domain.request.HouseRequest;
import com.example.housingservice.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class HouseController {
    private HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping
    public List<House> getAllHouse() {
        return houseService.getAllHouse();
    }

    @GetMapping("/{id}")
    public House getHouseById(@PathVariable int id) {
        return houseService.getHouseById(id);
    }

    @PostMapping
    public String createNewHouse(@RequestBody HouseRequest request, @RequestParam int landlordId) {
        return houseService.createNewHouse(request, landlordId);
    }
}
