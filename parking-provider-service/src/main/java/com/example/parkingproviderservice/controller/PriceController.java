package com.example.parkingproviderservice.controller;

import java.util.List;

import com.example.parkingproviderservice.dto.FareCalculatorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingproviderservice.exception.ResourceNotFoundException;
import com.example.parkingproviderservice.model.ChargeType;
import com.example.parkingproviderservice.model.Price;
import com.example.parkingproviderservice.model.SpotType;
import com.example.parkingproviderservice.service.PriceService;

@RestController
@RequestMapping("/price-service")
@CrossOrigin(maxAge = 3600)
public class PriceController {

	@Autowired
	private PriceService priceService;

	@PostMapping("/provider/add")
	public ResponseEntity<Price> addPrice(@RequestBody Price price) throws Exception {
		price = priceService.addPrice(price);
		return ResponseEntity.ok(price);
	}

	@GetMapping("/public/get-price/{areaId}")
	public ResponseEntity<List<Price>> getPrice(@PathVariable String areaId, @RequestParam(defaultValue = "") SpotType spotType,
			@RequestParam(defaultValue = "") ChargeType chargeType) throws ResourceNotFoundException {
		List<Price> prices = priceService.getPrice(areaId, spotType, chargeType);
		return ResponseEntity.ok(prices);
	}

	@GetMapping("/public/get-by-id/{priceId}")
	public ResponseEntity<Price> getPriceById(@PathVariable String priceId) throws ResourceNotFoundException {
		Price price = priceService.getPriceById(priceId);
		return ResponseEntity.ok(price);
	}

	@PutMapping("/provider/update")
	public ResponseEntity<Price> updatePrice(@RequestBody Price price) throws ResourceNotFoundException {
		System.out.println(price);
		price = priceService.updatePrice(price);
		return ResponseEntity.ok(price);
	}

	@GetMapping("/public/calculate-total")
	public ResponseEntity<Double> calculateAmount(@RequestBody FareCalculatorDto fareCalculatorDto) throws ResourceNotFoundException {
		double totalamount = priceService.calculateAmount(fareCalculatorDto);
		return ResponseEntity.ok(totalamount);
	}
}
