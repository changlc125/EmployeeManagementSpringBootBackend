package com.example.employeeservice.service.remote;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("housing-service")
public interface RemoteHousingService {
}
