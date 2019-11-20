package com.redfield.msexample.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable(value="from") String from,
												  @PathVariable(value="to") String to,
												  @PathVariable(value="quantity") BigDecimal quantity)
	{
		System.out.println(">>>>>>" + from + "-" + to +"-" + quantity + "<<<<<<");
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		//acesso a URL e recebo um JSON, de um serviço externo
		ResponseEntity<CurrencyConversionBean> responseEntityCCB = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
																									CurrencyConversionBean.class,
																									uriVariables);
		CurrencyConversionBean ccbResponse = responseEntityCCB.getBody();
		if(ccbResponse == null)
			return new CurrencyConversionBean(1L, from, to, BigDecimal.ONE, quantity, quantity, 0);
		
		logger.info("{}", ccbResponse);
		return new CurrencyConversionBean(ccbResponse.getId(),
										  from,
										  to,
										  ccbResponse.getConversionMultiple2(),
										  quantity,
										  quantity.multiply(ccbResponse.getConversionMultiple2()),
										  ccbResponse.getPort());
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable(value="from") String from,
													  @PathVariable(value="to") String to,
													  @PathVariable(value="quantity") BigDecimal quantity)
	{
		System.out.println(">>>>>>" + from + "-" + to +"-" + quantity + "<<<<<<");
		CurrencyConversionBean ccbResponse = new CurrencyConversionBean();
		System.out.println(">>>>>>>>>>>>>>1>" + ccbResponse.getConversionMultiple2());
		ccbResponse = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
		System.out.println(">>>>>>>>>>>>>>2>" + ccbResponse.getConversionMultiple2());
		if(ccbResponse == null)
			return new CurrencyConversionBean(1L, from, to, BigDecimal.ONE, quantity, quantity, 0);
		return new CurrencyConversionBean(ccbResponse.getId(),
										  from,
										  to,
										  ccbResponse.getConversionMultiple2(),
										  quantity,
										  quantity.multiply(ccbResponse.getConversionMultiple2()),
										  ccbResponse.getPort());
	}
	
	@GetMapping("/currency-converter-vezes-1000/quantity/{quantity}")
	public CurrencyConversionBean valorVezes1000(@PathVariable(value="quantity") BigDecimal quantity)
	{
		System.out.println(">>>>>>" + quantity + "<<<<<<");
		CurrencyConversionBean ccbResponse = currencyExchangeServiceProxy.vezes1000();
		if(ccbResponse == null)
			return new CurrencyConversionBean(1L, "1000from", "1000to", BigDecimal.ONE, quantity, quantity, 0);
		return new CurrencyConversionBean(ccbResponse.getId(),
										  "1000from",
										  "1000to",
										  ccbResponse.getConversionMultiple2(),
										  quantity,
										  quantity.multiply(ccbResponse.getConversionMultiple2()),
										  ccbResponse.getPort());
	}

}
