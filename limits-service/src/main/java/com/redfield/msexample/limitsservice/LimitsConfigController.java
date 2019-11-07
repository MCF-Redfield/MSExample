package com.redfield.msexample.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redfield.msexample.limitsservice.bean.LimitConfig;

@RestController
public class LimitsConfigController
{
		@Autowired
		private Configuration config;
	
	@GetMapping("/limits")
	public LimitConfig retrieveLimitsFromConfig()
	{
		return new LimitConfig(config.getMinimumq(), config.getMaximum());
	}
	
}
