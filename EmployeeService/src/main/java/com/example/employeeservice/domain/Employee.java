package com.example.employeeservice.domain;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Document(collection = "employee")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private String id;
    private Integer userID;
    private String firstName;
    private String lastName;
    private String middleName;
    private String preferredName;
    private String email;
    private String cellPhone;
    private String alternativePhone;
    private String gender;
    private String ssn;
    private Date dob;
    private Date startDate;
    private Date endDate;
    private String driveLicense;
    private Date driveLicenseExpiration;
    private String houseID;
    private List<Contact> contacts = new ArrayList<>();
    private List<Address> addresses = new ArrayList<>();
    private List<VisaStatus> visaStatus = new ArrayList<>();
    private List<PersonalDocument> personalDocuments = new ArrayList<>();
}
