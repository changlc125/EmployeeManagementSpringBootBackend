package com.example.onboardingservice.entity.EmployeeService;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonalDocument {
    private String path;
    private String title;
    private String comment;
    private Date createDate;
}
