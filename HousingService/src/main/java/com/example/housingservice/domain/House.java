package com.example.housingservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "House")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class House {
    @Id
    @Column(name = "house_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int houseId;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;

    @Column(name = "address")
    private String address;

    @Column(name = "max_occupant")
    private int maxOccupant;

    @JsonIgnore
    @OneToMany(mappedBy = "house")
    private List<Facility> facilities;
}
