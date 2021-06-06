package com.shrihari.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	
	@Autowired
	private Environment environment;

	@GetMapping(path="/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(
			@PathVariable String from,@PathVariable String to) {
		
		/*CurrencyExchange currencyExchange = new CurrencyExchange(1000L,from,to,
						BigDecimal.valueOf(50));
				----> Getting locally		
			*/
		
		
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		// Returning the currency exchange values from the JPA or in memory h2 database
		
		
		if(currencyExchange==null) {
			
			throw new RuntimeException("Unable to find from "+from+"to"+to+"on the database.");
		}
		
		String port = environment.getProperty("local.server.port");
		
		currencyExchange.setEnvironment(port); // we are trying to return the port number back 
		
		return currencyExchange;
		
	}
	
	
	
}
