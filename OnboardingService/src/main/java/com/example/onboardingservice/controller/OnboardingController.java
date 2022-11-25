package com.example.onboardingservice.controller;

import com.example.onboardingservice.entity.ApplicationService.ApplicationWorkflow;
import com.example.onboardingservice.entity.EmployeeService.Employee;
import com.example.onboardingservice.service.OnboardingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@Api(value = "Onboarding RESTful endpoints")
public class OnboardingController {
    private OnboardingService onboardingService;

    @Autowired
    public OnboardingController(OnboardingService onboardingService) {
        this.onboardingService = onboardingService;
    }



    @GetMapping("onboarding/status")
    @ApiOperation(value = "Find an onboarding status by employee ID", response = String.class)
    public String getApplicationStatusByEmployeeId(@RequestParam String employeeId) {
        return onboardingService.getApplicationStatus(employeeId);
    }

    @GetMapping("onboarding/start-new-application")
    @ApiOperation(value = "Create a new application", response = String.class)
    public String startNewApplication(@RequestParam String employeeId) {
        return onboardingService.startNewApplication(employeeId);
    }

    @GetMapping("onboarding/get-pending-applications")
    @ApiOperation(value = "Find all application with pending status", response = Iterable.class)
    public List<ApplicationWorkflow> getPendingApplications(){
        return onboardingService.getAllPendingApplicationWorkflows();
    }


    @PostMapping("/workflows/submit/{applicationWorkflowId}")
    @ApiOperation(value = "Submit a specific application（from never submit to pending）", response = String.class)
    public String submitApplication(@RequestBody Employee employee, @PathVariable int applicationWorkflowId){
        return onboardingService.submitApplication(employee, applicationWorkflowId);
    }
}