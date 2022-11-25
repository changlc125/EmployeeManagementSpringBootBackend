package com.example.housingservice.controller;

import com.example.housingservice.domain.House;
import com.example.housingservice.domain.request.HouseRequest;
import com.example.housingservice.service.HouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houses")
@Api(value = "House RESTful endpoints")
public class HouseController {
    private HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping
    @ApiOperation(value = "Find all houses", response = Iterable.class)
    public List<House> getAllHouse() {
        return houseService.getAllHouse();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find a house by ID", response = House.class)
    public House getHouseById(@PathVariable int id) {
        return houseService.getHouseById(id);
    }

    @PostMapping
    @ApiOperation(value = "Create a house by ID", response = String.class)
    public String createNewHouse(@RequestBody HouseRequest request, @RequestParam int landlordId) {
        return houseService.createNewHouse(request, landlordId);
    }
}
