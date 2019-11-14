package com.redfield.msexample.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean
{
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private int port;	
	
	public CurrencyConversionBean() {
		super();
	}
	public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalCalculatedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
	}
	public final Long getId() {
		return id;
	}
	public final void setId(Long id) {
		this.id = id;
	}
	public final String getFrom() {
		return from;
	}
	public final void setFrom(String from) {
		this.from = from;
	}
	public final String getTo() {
		return to;
	}
	public final void setTo(String to) {
		this.to = to;
	}
	public final BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public final void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public final BigDecimal getQuantity() {
		return quantity;
	}
	public final void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public final BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public final void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public final int getPort() {
		return port;
	}
	public final void setPort(int port) {
		this.port = port;
	}
	
	
	
}
