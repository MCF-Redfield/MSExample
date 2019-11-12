package com.redfield.msexample.currencyexchangeservice;

import java.math.BigDecimal;

public class ExchangeValue
{
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	
	public ExchangeValue()
	{}
	
	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public final Long getId() {
		return id;
	}

	public final String getFrom() {
		return from;
	}

	public final String getTo() {
		return to;
	}

	public final BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	
	
	
}
