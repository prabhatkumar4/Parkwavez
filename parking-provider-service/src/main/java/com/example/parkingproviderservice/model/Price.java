package com.example.parkingproviderservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "parice")
public class Price {
	@Id
	private String priceId;
	private String areaId;
	private SpotType spotType;
	private ChargeType chargeType;
	private double price;
	private double discount;
}
