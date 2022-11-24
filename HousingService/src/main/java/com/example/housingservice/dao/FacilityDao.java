package com.example.housingservice.dao;

import com.example.housingservice.domain.Facility;
import com.example.housingservice.domain.Landlord;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FacilityDao extends AbstractHibernateDao{
    public FacilityDao() {setClazz(Facility.class);}

    // get all
    public List<Facility> getAllFacility() {
        return this.getAll();
    }

    // get by id
    public Facility getFacilityById(int id) {
        return (Facility) this.findById(id);
    }

    // create
    public boolean createNewFacility(Facility facility) {
        Facility facilityChecked = getFacilityById(facility.getFacilityId());

        if(facilityChecked != null){
            return false;
        }

        this.add(facility);
        return true;
    }
}
