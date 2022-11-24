package com.example.housingservice.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LandlordRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
}
