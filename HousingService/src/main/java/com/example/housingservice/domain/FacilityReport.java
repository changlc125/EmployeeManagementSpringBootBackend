package com.example.housingservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FacilityReport")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacilityReport {
    @Id
    @Column(name = "facility_report_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facilityReportId;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "status")
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "facilityReport")
    private List<FacilityReportDetail> facilityReportDetails;
}
