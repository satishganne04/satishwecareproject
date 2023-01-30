package com.User.User.coachFeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "api-gateway")
public interface CoachFeignClient {
	
	 @GetMapping("/coach-service/coaches/data")
	    public ResponseEntity<?> getAllData();

}
