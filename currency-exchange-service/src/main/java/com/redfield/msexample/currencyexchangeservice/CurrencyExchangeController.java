package com.redfield.msexample.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.redfield.msexample.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController
{
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository exchangeValueR;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable(value="from") String from, @PathVariable(value="to") String to)
	{	
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + from);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + to);
		ExchangeValue exchangeValue = exchangeValueR.findByFromAndTo(from,to);//uso o nome que esta na classe(yes-from, not-currency_from)
		if(exchangeValue==null)
			exchangeValue = new ExchangeValue(1234L, from, to, BigDecimal.valueOf(150));
		System.out.println(">>>>>>>>>>>>>>"+exchangeValue.getConversionMultiple());
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue; 
		
	}
}
