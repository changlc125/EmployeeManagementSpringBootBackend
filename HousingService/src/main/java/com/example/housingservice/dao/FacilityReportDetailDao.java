package com.example.housingservice.dao;

import com.example.housingservice.domain.FacilityReport;
import com.example.housingservice.domain.FacilityReportDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacilityReportDetailDao extends AbstractHibernateDao{

    public FacilityReportDetailDao() {setClazz(FacilityReportDetail.class);}

    // get all
    public List<FacilityReportDetail> getAllFacilityReportDetail() {
        return this.getAll();
    }

    // get by id
    public FacilityReportDetail getFacilityReportDetailById(int id) {
        return (FacilityReportDetail) this.findById(id);
    }

    // create
    public boolean createNewFacilityReportDetail(FacilityReportDetail facilityReportDetail) {
        FacilityReportDetail facilityReportDetailChecked = getFacilityReportDetailById(facilityReportDetail.getFacilityReportDetailId());

        if(facilityReportDetailChecked != null){
            return false;
        }

        this.add(facilityReportDetail);
        return true;
    }
}
