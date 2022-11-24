package com.example.housingservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Landlord")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Landlord {
    @Id
    @Column(name = "landlord_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int landlordId;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "landlord")
    private List<House> houses;
}
