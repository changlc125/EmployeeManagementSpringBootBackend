package com.example.onboardingservice.entity.EmployeeService;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private String id;
    private Integer UserID;
    private String FirstName;
    private String LastName;
    private String MiddleName;
    private String PreferredName;
    private String Email;
    private String CellPhone;
    private String AlternativePhone;
    private String Gender;
    private String SSN;
    private Date DOB;
    private Date StartDate;
    private Date EndDate;
    private String DriveLicense;
    private Date DriveLicenseExpiration;
    private String HouseID;
    private List<Contact> Contacts = new ArrayList<>();
    private List<Address> Addresses = new ArrayList<>();
    private List<VisaStatus> visaStatus = new ArrayList<>();
    private List<PersonalDocument> PersonalDocuments = new ArrayList<>();
}
