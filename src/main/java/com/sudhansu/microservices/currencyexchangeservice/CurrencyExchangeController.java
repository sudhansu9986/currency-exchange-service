package com.sudhansu.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
		ExchangeValue exVal = exchangeValueRepository.findByFromAndTo(from, to);
	//	ExchangeValue exVal = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
		exVal.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exVal;
	}
	
	@GetMapping("/currency-exchange/conversionMultiple/{conversionMultiple}")
	public ExchangeValue retrieveExchangeValue(@PathVariable BigDecimal conversionMultiple){
		ExchangeValue exVal = exchangeValueRepository.findByConversionMultiple(conversionMultiple);
	//	ExchangeValue exVal = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
		exVal.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exVal;
	}
}
