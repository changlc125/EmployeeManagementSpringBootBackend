package com.example.employeeservice.service.remote;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("onboarding-service")
public interface RemoteOnboardingService {
}
