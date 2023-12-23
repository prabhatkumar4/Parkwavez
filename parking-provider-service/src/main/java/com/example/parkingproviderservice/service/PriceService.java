package com.example.parkingproviderservice.service;

import java.util.List;

import com.example.parkingproviderservice.dto.FareCalculatorDto;
import com.example.parkingproviderservice.exception.ResourceNotFoundException;
import com.example.parkingproviderservice.model.ChargeType;
import com.example.parkingproviderservice.model.Price;
import com.example.parkingproviderservice.model.SpotType;

public interface PriceService {
	public Price addPrice(Price price) throws Exception;

	public List<Price> getPrice(String areaId, SpotType spotype, ChargeType chargeType)
			throws ResourceNotFoundException;

	public Price getPriceById(String priceId) throws ResourceNotFoundException;

	public Price updatePrice(Price price) throws ResourceNotFoundException;

	public double calculateAmount(FareCalculatorDto fareCalculatorDto)
			throws ResourceNotFoundException;
}
