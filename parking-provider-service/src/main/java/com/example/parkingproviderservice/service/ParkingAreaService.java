package com.example.parkingproviderservice.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.parkingproviderservice.exception.ResourceNotFoundException;
import com.example.parkingproviderservice.model.ParkingArea;

public interface ParkingAreaService {
	ParkingArea addParkingArea(long providerId, ParkingArea parkingArea) throws ResourceNotFoundException;

	Page<ParkingArea> getParkingAreaByProviderId(long providerId, Pageable pagable) throws ResourceNotFoundException;

	public ParkingArea getById(String areaId) throws ResourceNotFoundException;

	public ParkingArea update(ParkingArea parkingArea) throws ResourceNotFoundException;

	public void delete(String areaId) throws ResourceNotFoundException;

	public Page<ParkingArea> getAll(Pageable pagable);

	public Page<ParkingArea> getByCity(String city, Pageable pagable);

	public Page<ParkingArea> findNearByParkingArea(double latitude, double longitude, String range, Pageable pagable);
}
