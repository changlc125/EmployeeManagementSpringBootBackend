package com.example.housingservice.dao;

import com.example.housingservice.domain.FacilityReport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacilityReportDao extends AbstractHibernateDao{

    public FacilityReportDao() {setClazz(FacilityReport.class);}

    // get all
    public List<FacilityReport> getAllFacilityReport() {
        return this.getAll();
    }

    // get by id
    public FacilityReport getFacilityReportById(int id) {
        return (FacilityReport) this.findById(id);
    }

    // create
    public boolean createNewFacilityReport(FacilityReport facilityReport) {
        FacilityReport facilityReportChecked = getFacilityReportById(facilityReport.getFacilityReportId());

        if(facilityReportChecked != null){
            return false;
        }

        this.add(facilityReport);
        return true;
    }
}
