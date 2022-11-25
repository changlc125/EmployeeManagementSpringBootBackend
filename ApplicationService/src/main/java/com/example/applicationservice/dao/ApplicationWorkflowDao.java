package com.example.applicationservice.dao;


import com.example.applicationservice.domain.ApplicationWorkflow;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ApplicationWorkflowDao extends AbstractHibernateDao{
    public ApplicationWorkflowDao(){setClazz(ApplicationWorkflow.class);}

    public List<ApplicationWorkflow> getAllApplicationWorkflow() {
        return this.getAll();
    }

    public List<ApplicationWorkflow> getAllPendingApplicationWorkflow() {
        List<ApplicationWorkflow> applicationWorkflows = this.getAll();

        return applicationWorkflows.stream()
                .filter(aw -> aw.getStatus().equals("Pending"))
                .collect(Collectors.toList());
    }

    public ApplicationWorkflow getApplicationWorkflowById(int digitalDocumentId){
        return (ApplicationWorkflow) this.findById(digitalDocumentId);
    }

    public ApplicationWorkflow createNewApplicationWorkflow(String employeeId){
        ApplicationWorkflow applicationWorkflow = ApplicationWorkflow.builder()
                .employeeId(employeeId)
                .createDate(new Date())
                .lastModificationDate(new Date())
                .status("Never Submitted")
                .comment("")
                .build();

        this.add(applicationWorkflow);

        return applicationWorkflow;
    }

    public ApplicationWorkflow getApplicationWorkflowByEmployeeId(String employeeId){
        List<ApplicationWorkflow> applicationWorkflows = getAllApplicationWorkflow();

        Optional<ApplicationWorkflow> applicationWorkflow = applicationWorkflows.stream()
                .filter(aw -> Objects.equals(aw.getEmployeeId(), employeeId)).max(Comparator.comparing(ApplicationWorkflow::getApplicationWorkflowId));

        return applicationWorkflow.orElse(null);
    }

    public String acceptApplicationWorkflowById(int applicationId, boolean accept){
        ApplicationWorkflow applicationWorkflow = getApplicationWorkflowById(applicationId);
        String status = accept ? "Approved" : "Rejected";

        if(applicationWorkflow == null){return "Application not found";}
        if(applicationWorkflow.getStatus().equals("Never Submitted")){return "Application not finished";}

        Session session = this.getCurrentSession();

        applicationWorkflow.setStatus(status);

        session.update(applicationWorkflow);
        return "Application was " + status;
    }

    public String submitApplicationWorkflowById(int applicationId){
        ApplicationWorkflow applicationWorkflow = getApplicationWorkflowById(applicationId);
        if(applicationWorkflow == null){return "Application not found";}

        Session session = this.getCurrentSession();

        applicationWorkflow.setStatus("Pending");

        session.update(applicationWorkflow);
        return "Application was submitted, please wait for HR approval";
    }
}
