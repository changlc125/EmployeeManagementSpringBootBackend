package com.example.housingservice.dao;

import com.example.housingservice.domain.House;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HouseDao extends AbstractHibernateDao{

    public HouseDao(){setClazz(House.class);}

    public List<House> getAllHouse() {
        return this.getAll();
    }

    public House getHouseById(int id) {
        return (House) this.findById(id);
    }

    public boolean createNewHouse(House house){
        House houseChecked = getHouseById(house.getHouseId());

        if(houseChecked != null){
            return false;
        }

        this.add(house);
        return true;
    }

    public String deleteHouse(House house) {
        House houseChecked = getHouseById(house.getHouseId());

        if (houseChecked != null) {
            this.delete(houseChecked);
            System.out.println("Deleted the house successfully");
            return "Deleted the house successfully";
        }

        return "This house is not exist";
    }

}
