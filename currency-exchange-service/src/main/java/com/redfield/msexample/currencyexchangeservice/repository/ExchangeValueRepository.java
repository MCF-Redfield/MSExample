package com.redfield.msexample.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redfield.msexample.currencyexchangeservice.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{

	ExchangeValue findByFromAndTo(String from, String to);

}
