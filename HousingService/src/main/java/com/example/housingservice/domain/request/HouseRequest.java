package com.example.housingservice.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseRequest {
    private String address;
    private int maxOccupant;
}
