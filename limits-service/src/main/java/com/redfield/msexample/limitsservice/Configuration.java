package com.redfield.msexample.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-servic")
public class Configuration
{
	private int minimum;
	private int maximum;
	
	public int getMinimumL() {
		return minimum;
	}
	public void setMinimumL(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	
}
