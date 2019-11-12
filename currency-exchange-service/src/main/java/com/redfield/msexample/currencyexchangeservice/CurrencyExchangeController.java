package com.redfield.msexample.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable(value="from") String from, @PathVariable(value="to") String to)
	{
		
		return new ExchangeValue(1234L, from, to, BigDecimal.valueOf(150));
		
	}
}
