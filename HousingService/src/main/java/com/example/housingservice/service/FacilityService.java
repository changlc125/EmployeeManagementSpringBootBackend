package com.example.housingservice.service;

import com.example.housingservice.dao.FacilityDao;
import com.example.housingservice.domain.Facility;
import com.example.housingservice.domain.House;
import com.example.housingservice.domain.Landlord;
import com.example.housingservice.domain.request.FacilityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService {
    private FacilityDao facilityDao;
    private HouseService houseService;

    @Autowired
    public FacilityService(FacilityDao facilityDao, HouseService houseService) {
        this.facilityDao = facilityDao;
        this.houseService = houseService;
    }

    public List<Facility> getAllFacility() {
        return facilityDao.getAllFacility();
    }

    public Facility getFacilityById(int id) {
        return facilityDao.getFacilityById(id);
    }

    public String createNewFacility(FacilityRequest request, int houseId) {
        House house = houseService.getHouseById(houseId);

        if(house == null){return "House doesn't exist";}

        Facility facility = Facility.builder()
                .house(house)
                .type(request.getType())
                .description(request.getDescription())
                .quantity(request.getQuantity())
                .build();

        if (facilityDao.createNewFacility(facility)) {
            return "Facility is added";
        }
        return "Facility is already existed";
    }
}
