package com.example.employeeservice.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact {

    private String firstName;
    private String lastName;
    private String cellPhone;
    private String alternativePhone;
    private String email;
    private String relationship;
    private String type;
}
