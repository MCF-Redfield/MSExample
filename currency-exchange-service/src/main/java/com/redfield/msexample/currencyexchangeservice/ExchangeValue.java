package com.redfield.msexample.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue
{
	@Id
	private Long id;
	@Column(name="currency_from")
	private String from;
	@Column(name="currency_to")
	private String to;
	private BigDecimal conversionMultiple2;
	private int port;
	
	public ExchangeValue()
	{}
	
	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple2) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple2 = conversionMultiple2;
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

	public final BigDecimal getConversionMultiple2() {
		return conversionMultiple2;
	}

	public final int getPort() {
		return port;
	}

	public final void setPort(int port) {
		this.port = port;
	}
	
	
	
}
