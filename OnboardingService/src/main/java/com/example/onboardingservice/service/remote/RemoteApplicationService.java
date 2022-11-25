package com.example.onboardingservice.service.remote;

import com.example.onboardingservice.entity.ApplicationService.ApplicationWorkflow;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "application-service", path = "application-service")
public interface RemoteApplicationService {

    @GetMapping("/workflows/{applicationWorkflowId}")
    ApplicationWorkflow getApplicationWorkflowById(@PathVariable(name = "applicationWorkflowId") int applicationWorkflowId);

    @GetMapping("/workflows/applicationStatus")
    String getApplicationStatus(@RequestParam String employeeId);

    @PostMapping("/workflows/newApplication")
    String startNewApplicaiton(@RequestParam String employeeId);

    @GetMapping("/workflows/pending")
    List<ApplicationWorkflow> getAllPendingApplicationWorkflows();

    @PatchMapping("/workflows/{applicationWorkflowId}/submit")
    String submitApplicationWorkflowId(@PathVariable int applicationWorkflowId);
}
