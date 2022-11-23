package com.example.employeeservice.service.remote;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("application-service")
public interface RemoteApplicationService {

    //mapping and methods
}
