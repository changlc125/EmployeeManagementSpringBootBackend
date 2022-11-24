package com.example.housingservice.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FacilityReportDetailRequest {
    private String comment;
    private Date createDate;
    private Date lastModificationDate;
}
