package com.example.housingservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Facility")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Facility {
    @Id
    @Column(name = "facility_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facilityId;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "quantity")
    private int quantity;

    @JsonIgnore
    @OneToMany(mappedBy = "facility")
    private List<FacilityReport> facilityReports;
}
