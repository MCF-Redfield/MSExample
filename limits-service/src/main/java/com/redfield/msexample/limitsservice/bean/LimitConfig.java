package com.redfield.msexample.limitsservice.bean;

public class LimitConfig
{
	private int minimum;
	private int maximum;
	
	protected LimitConfig()
	{}
	
	public LimitConfig(int minimum, int maximum)
	{
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	public final int getMinimum() {
		return minimum;
	}
	public final int getMaximum() {
		return maximum;
	}
	
	
}
