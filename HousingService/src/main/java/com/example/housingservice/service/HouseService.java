package com.example.housingservice.service;

import com.example.housingservice.dao.HouseDao;
import com.example.housingservice.domain.House;
import com.example.housingservice.domain.Landlord;
import com.example.housingservice.domain.request.HouseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    private HouseDao houseDao;
    private LandlordService landlordService;

    @Autowired
    public HouseService(HouseDao houseDao, LandlordService landlordService) {
        this.houseDao = houseDao;
        this.landlordService = landlordService;
    }

    public List<House> getAllHouse() {
        return houseDao.getAllHouse();
    }

    public House getHouseById(int id) {
        return houseDao.getHouseById(id);
    }

    public String createNewHouse(HouseRequest request, int landlordId) {
        Landlord landlord = landlordService.getLandlordById(landlordId);
        if(landlord == null) {return "Landlord doesn't exist";}

        House house = House.builder()
                .landlord(landlord)
                .address(request.getAddress())
                .maxOccupant(request.getMaxOccupant())
                .build();

        if (houseDao.createNewHouse(house)) {
            return "House is added";
        }
        return "House is already existed";
    }
}
