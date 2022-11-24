package com.example.housingservice.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacilityRequest {
    private String type;
    private String description;
    private int quantity;
}
