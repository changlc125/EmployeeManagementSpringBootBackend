package com.example.onboardingservice.entity.EmployeeService;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VisaStatus {
    private String visaType;
    private String activeFlag;
    private Date startDate;
    private Date endDate;
    private Date lastModificationDate;

}
