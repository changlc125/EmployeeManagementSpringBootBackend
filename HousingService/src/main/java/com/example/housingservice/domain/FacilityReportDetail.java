package com.example.housingservice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FacilityReportDetail")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacilityReportDetail {

    @Id
    @Column(name = "facility_report_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facilityReportDetailId;

    @ManyToOne
    @JoinColumn(name = "facility_report_id")
    private FacilityReport facilityReport;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_modification_date")
    private Date lastModificationDate;
}
