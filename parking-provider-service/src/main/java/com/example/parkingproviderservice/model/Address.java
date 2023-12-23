package com.example.parkingproviderservice.model;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private String street;
	private String city;
	private int zip;
	private String state;
	private GeoPoint location;
}
