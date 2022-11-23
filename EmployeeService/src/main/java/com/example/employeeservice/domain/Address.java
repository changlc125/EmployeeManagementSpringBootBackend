package com.example.employeeservice.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;
}
