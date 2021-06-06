package com.Shrihari.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shrihari.microservices.limitsservice.bean.City;
import com.Shrihari.microservices.limitsservice.bean.Limits;
import com.Shrihari.microservices.limitsservice.configuration.Configuration;
import com.Shrihari.microservices.limitsservice.configuration.ConfigurationForCities;

@RestController
public class LimitsController {

	@Autowired
	Configuration configuration;
	 
	@Autowired
	ConfigurationForCities configcities;
	
	
	@GetMapping(path="/limits")
	public Limits retriveLiits() {
			return new Limits(configuration.getMinimum() ,
					configuration.getMaximum());
	//return new Limits(1,1000); 
	}
	
	@GetMapping(path="/limits-static/")
	public Limits retrieveLimitsStatic() {
		
		return new Limits(0,2500);
	}
	
	@GetMapping(path="/cities")
	public City retriveCity() {
		
		return new City(configcities.getName(),
					configcities.getState(),
					configcities.getState(),
					configcities.getZipcode());
		
		
		
	}
	
	
	
	
}
