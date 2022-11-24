package com.example.housingservice.dao;


import com.example.housingservice.domain.Landlord;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class LandlordDao extends AbstractHibernateDao{

    public LandlordDao(){setClazz(Landlord.class);}

    public List<Landlord> getAllLandlord() {
        return this.getAll();
    }

    public Landlord getLandlordById(int id) {
        return (Landlord) this.findById(id);
    }

    public boolean createNewLandlord(Landlord landlord) {
        Landlord landlordChecked = getLandlordById(landlord.getLandlordId());

        if(landlordChecked != null){
            return false;
        }

        this.add(landlord);
        return true;
    }
}
