package com.shrihari.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = 
				LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//@Retry(name = "sample-api",fallbackMethod="hardCodedResponse")
	//@CircuitBreaker(name = "sample-api",fallbackMethod="hardCodedResponse")
	@RateLimiter(name="default")    
	// 10s => 10,000 calls to sample-api
	@Bulkhead(name="sample-api")  // how many concurrent calls are allowed 
	public String sampleApi() {
		
		logger.info("Sample API call received");
		
		ResponseEntity<String> forEntity = new RestTemplate()
											.getForEntity("http:"
													+ "//localhost:8080/some-dummy", 
												String.class);	
		String body = forEntity.getBody();
		
		return body;
	}
	
	public String hardCodedResponse(Exception ex) {
		
		return "Method call failed , you are getting a hardcoded response";
	}

}
