package com.example.housingservice.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FacilityReportRequest {
    private String title;
    private String description;
    private Date createDate;
    private String status;
}
