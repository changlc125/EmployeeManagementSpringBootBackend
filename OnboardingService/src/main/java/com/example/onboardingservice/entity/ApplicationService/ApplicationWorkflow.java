package com.example.onboardingservice.entity.ApplicationService;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationWorkflow {
    private int applicationWorkflowId;
    private String employeeId;
    private Date createDate;
    private Date lastModificationDate;
    private String status;
    private String comment;
}
