package com.example.housingservice.service;


import com.example.housingservice.dao.LandlordDao;
import com.example.housingservice.domain.Landlord;
import com.example.housingservice.domain.request.LandlordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandlordService {

    private LandlordDao landlordDao;

    @Autowired
    public LandlordService(LandlordDao landlordDao) {
        this.landlordDao = landlordDao;
    }

    public List<Landlord> getAllLandlord() {
        return landlordDao.getAllLandlord();
    }

    public Landlord getLandlordById(int id) {
        return landlordDao.getLandlordById(id);
    }

    public String createNewLandlord(LandlordRequest request) {
        Landlord landlord = Landlord.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();

        if (landlordDao.createNewLandlord(landlord)) {
            return "Landlord is added";
        }
        return "Landlord is already existed";
    }
}
