package com.example.applicationservice.service;

import com.example.applicationservice.dao.ApplicationWorkflowDao;
import com.example.applicationservice.domain.ApplicationWorkflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ApplicationWorkflowService {
    private ApplicationWorkflowDao applicationWorkflowDao;

    @Autowired
    public ApplicationWorkflowService(ApplicationWorkflowDao applicationWorkflowDao){
        this.applicationWorkflowDao = applicationWorkflowDao;
    }

    @Transactional
    public List<ApplicationWorkflow> getAllApplicationWorkflow(){
        return applicationWorkflowDao.getAllApplicationWorkflow();
    }

    @Transactional
    public List<ApplicationWorkflow> getAllPendingApplicationWorkflow(){
        return applicationWorkflowDao.getAllPendingApplicationWorkflow();
    }

    @Transactional
    public String updateApplicationWorkflow(int applicationWorkflowId, boolean accept){
        return applicationWorkflowDao.acceptApplicationWorkflowById(applicationWorkflowId, accept);
    }

    @Transactional
    public ApplicationWorkflow getApplicationWorkflowById(int applicationWorkflowId){
        return applicationWorkflowDao.getApplicationWorkflowById(applicationWorkflowId);
    }

    @Transactional
    public String startNewApplication(String employeeId){
       String status = getApplicationStatus(employeeId);

       if(status.equals("Pending")){
           applicationWorkflowDao.createNewApplicationWorkflow(employeeId);
           return "Application is pending";
       }else if(status.equals("Never Submitted")){
           return "Active application already exists";
       }

       applicationWorkflowDao.createNewApplicationWorkflow(employeeId);
       return "New Application Created";
    }

    @Transactional
    public String getApplicationStatus(String employeeId){
        ApplicationWorkflow application = applicationWorkflowDao.getApplicationWorkflowByEmployeeId(employeeId);

        if(application == null){
            return "No Application";
        }
        return application.getStatus();
    }

    @Transactional
    public String submitApplicationWorkflow(int applicationWorkflowId){
        return applicationWorkflowDao.submitApplicationWorkflowById(applicationWorkflowId);
    }
}
