package com.example.applicationservice.controller;

import com.example.applicationservice.domain.ApplicationWorkflow;
import com.example.applicationservice.service.ApplicationWorkflowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Application RESTful endpoints")
public class ApplicationWorkFlowController {
    private final ApplicationWorkflowService applicationWorkflowService;

    @Autowired
    public ApplicationWorkFlowController(ApplicationWorkflowService applicationWorkflowService){
        this.applicationWorkflowService = applicationWorkflowService;
    }

    @GetMapping("/workflows")
    @ApiOperation(value = "Find all workflows", response = Iterable.class)
    public List<ApplicationWorkflow> getAllApplicationWorkflows(){
        return applicationWorkflowService.getAllApplicationWorkflow();
    }

    @GetMapping("/workflows/pending")
    @ApiOperation(value = "Find all workflows with pending status", response = Iterable.class)
    public List<ApplicationWorkflow> getAllPendingApplicationWorkflows(){
        return applicationWorkflowService.getAllPendingApplicationWorkflow();
    }

    @GetMapping("/workflows/{applicationWorkflowId}")
    @ApiOperation(value = "Find a Application  by application workflow ID", response = ApplicationWorkflow.class)
    public ApplicationWorkflow getApplicationWorkflowById(@PathVariable int applicationWorkflowId){
        return applicationWorkflowService.getApplicationWorkflowById(applicationWorkflowId);
    }

    @GetMapping("/workflows/applicationStatus")
    @ApiOperation(value = "Find an application by employee ID", response = String.class)
    public String getApplicationStatus(@RequestParam String employeeId){
        return applicationWorkflowService.getApplicationStatus(employeeId);
    }

    @PostMapping("/workflows/newApplication")
    @ApiOperation(value = "Create a new application workflow by employee ID", response = String.class)
    public String startNewApplication(@RequestParam String employeeId){
        return applicationWorkflowService.startNewApplication(employeeId);
    }

    @PatchMapping("/workflows/{applicationWorkflowId}")
    @ApiOperation(value = "Update an application workflow status by application ID (accept or reject)", response = String.class)
    public String updateApplicationWorkflowId(@PathVariable int applicationWorkflowId, @RequestParam boolean accept){
        return applicationWorkflowService.updateApplicationWorkflow(applicationWorkflowId, accept);
    }

    @PostMapping("/workflows/{applicationWorkflowId}/submit")
    @ApiOperation(value = "Create an application workflow by application ID", response = String.class)
    public String submitApplicationWorkflowId(@PathVariable int applicationWorkflowId){
        return applicationWorkflowService.submitApplicationWorkflow(applicationWorkflowId);
    }
}
