package com.example.onboardingservice.service;

import com.example.onboardingservice.entity.ApplicationService.ApplicationWorkflow;
import com.example.onboardingservice.entity.EmployeeService.Employee;
import com.example.onboardingservice.service.remote.RemoteApplicationService;
import com.example.onboardingservice.service.remote.RemoteEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnboardingService {
    private RemoteEmployeeService employeeService;
    private RemoteApplicationService applicationService;

    @Autowired
    public void setEmployeeService(RemoteEmployeeService employeeService, RemoteApplicationService applicationService) {
        this.employeeService = employeeService;
        this.applicationService = applicationService;
    }

    public Employee getEmployeeById(String id) {
        return employeeService.getEmployeeById(id);
    }


    public List<ApplicationWorkflow> getAllPendingApplicationWorkflows() {return applicationService.getAllPendingApplicationWorkflows();}

    public String getApplicationStatus(String employeeId) {return applicationService.getApplicationStatus(employeeId);}

    public String startNewApplication(String employeeId) {return applicationService.startNewApplicaiton(employeeId);}

    public String submitApplication(Employee employee, int applicationWorkflowId){
        ApplicationWorkflow applicationWorkflow = applicationService.getApplicationWorkflowById(applicationWorkflowId);
        if(applicationWorkflow.getStatus().equals("Rejected")){
            return "This application was rejected, please start a new application";
        }

        employeeService.save(employee);
        applicationService.submitApplicationWorkflowId(applicationWorkflowId);

        return "Application submitted";
    }


}
