package com.redfield.msexample.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.redfield.msexample.limitsservice.bean.LimitConfig;

@RestController
public class LimitsConfigController
{
	@Autowired
	private Configuration config;

	@GetMapping("/limits")
	public LimitConfig retrieveLimitsFromConfig()
	{
		return new LimitConfig(config.getMinimumL(), config.getMaximumL());
	}

	@GetMapping("/testHystrix")
	@HystrixCommand(fallbackMethod = "fallbackMethodTestHystrix")
	public LimitConfig resteHystrix()
	{
		throw new RuntimeException("Indisponível");
	}
	
	public LimitConfig fallbackMethodTestHystrix()
	{
		return new LimitConfig(9, 999);
	}
}
