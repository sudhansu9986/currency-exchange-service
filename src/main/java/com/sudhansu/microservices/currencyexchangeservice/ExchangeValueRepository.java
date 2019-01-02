package com.sudhansu.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	ExchangeValue findByFromAndTo(String from, String to);
	ExchangeValue findByConversionMultiple(BigDecimal value);
}