package com.example.onboardingservice.controller;

import com.example.onboardingservice.entity.ApplicationService.ApplicationWorkflow;
import com.example.onboardingservice.entity.EmployeeService.Employee;
import com.example.onboardingservice.service.OnboardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class OnboardingController {
    private OnboardingService onboardingService;

    @Autowired
    public OnboardingController(OnboardingService onboardingService) {
        this.onboardingService = onboardingService;
    }



    @GetMapping("onboarding/status")
    public String getApplicationStatusByEmployeeId(@RequestParam String employeeId) {
        return onboardingService.getApplicationStatus(employeeId);
    }

    @GetMapping("onboarding/start-new-application")
    public String startNewApplication(@RequestParam String employeeId) {
        return onboardingService.startNewApplication(employeeId);
    }

    @GetMapping("onboarding/get-pending-applications")
    public List<ApplicationWorkflow> getPendingApplications(){
        return onboardingService.getAllPendingApplicationWorkflows();
    }


    @PostMapping("/workflows/submit/{applicationWorkflowId}")
    public String submitApplication(@RequestBody Employee employee, @PathVariable int applicationWorkflowId){
        return onboardingService.submitApplication(employee, applicationWorkflowId);
    }
}