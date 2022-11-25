package com.example.applicationservice.controller;

import com.example.applicationservice.domain.ApplicationWorkflow;
import com.example.applicationservice.service.ApplicationWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationWorkFlowController {
    private final ApplicationWorkflowService applicationWorkflowService;

    @Autowired
    public ApplicationWorkFlowController(ApplicationWorkflowService applicationWorkflowService){
        this.applicationWorkflowService = applicationWorkflowService;
    }

    @GetMapping("/workflows")
    public List<ApplicationWorkflow> getAllApplicationWorkflows(){
        return applicationWorkflowService.getAllApplicationWorkflow();
    }

    @GetMapping("/workflows/pending")
    public List<ApplicationWorkflow> getAllPendingApplicationWorkflows(){
        return applicationWorkflowService.getAllPendingApplicationWorkflow();
    }

    @GetMapping("/workflows/{applicationWorkflowId}")
    public ApplicationWorkflow getApplicationWorkflowById(@PathVariable int applicationWorkflowId){
        return applicationWorkflowService.getApplicationWorkflowById(applicationWorkflowId);
    }

    @GetMapping("/workflows/applicationStatus")
    public String getApplicationStatus(@RequestParam String employeeId){
        return applicationWorkflowService.getApplicationStatus(employeeId);
    }

    @PostMapping("/workflows/newApplication")
    public String startNewApplication(@RequestParam String employeeId){
        return applicationWorkflowService.startNewApplication(employeeId);
    }

    @PatchMapping("/workflows/{applicationWorkflowId}")
    public String updateApplicationWorkflowId(@PathVariable int applicationWorkflowId, @RequestParam boolean accept){
        return applicationWorkflowService.updateApplicationWorkflow(applicationWorkflowId, accept);
    }

    @PostMapping("/workflows/{applicationWorkflowId}/submit")
    public String submitApplicationWorkflowId(@PathVariable int applicationWorkflowId){
        return applicationWorkflowService.submitApplicationWorkflow(applicationWorkflowId);
    }
}
