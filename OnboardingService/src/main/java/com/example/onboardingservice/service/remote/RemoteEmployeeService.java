package com.example.onboardingservice.service.remote;

import com.example.onboardingservice.entity.EmployeeService.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "employee-service", path = "employee-service/api/")
public interface RemoteEmployeeService {
    @GetMapping("employee/{id}")
    Employee getEmployeeById(@PathVariable(name = "id") String id);

    @GetMapping( "/employee_userId/{userId}")
    Employee getEmployeeByUserID(@PathVariable(name = "userId") Integer userId);

    @PostMapping("/employee")
    String save(@RequestBody Employee employee);
}
