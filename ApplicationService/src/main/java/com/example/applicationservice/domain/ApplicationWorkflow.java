package com.example.applicationservice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ApplicationWorkflow")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationWorkflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_workflow_id")
    private int applicationWorkflowId;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_modification_date")
    private Date lastModificationDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comment")
    private String comment;
}
