package com.example.parkingproviderservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.parkingproviderservice.exception.ResourceNotFoundException;
import com.example.parkingproviderservice.model.ParkingArea;
import com.example.parkingproviderservice.repository.ParkingAreaRepository;
import com.example.parkingproviderservice.service.ParkingAreaService;

@Service
public class ParkingAreaServiceImpl implements ParkingAreaService {

	@Autowired
	private ParkingAreaRepository parkingAreaRepository;

	@Override
	public Page<ParkingArea> getParkingAreaByProviderId(long providerId, Pageable pagable)
			throws ResourceNotFoundException {
		return parkingAreaRepository.findByProviderId(providerId, pagable);
	}

	@Override
	public ParkingArea addParkingArea(long providerId, ParkingArea parkingArea) throws ResourceNotFoundException {
		parkingArea.setProviderId(providerId);
		return parkingAreaRepository.save(parkingArea);
	}

	@Override
	public ParkingArea update(ParkingArea parkingArea) throws ResourceNotFoundException {
		boolean isexist = parkingAreaRepository.existsById(parkingArea.getAreaId());
		if (!isexist) {
			throw new ResourceNotFoundException("ParkingArea not found with Id : " + parkingArea.getAreaId());
		}
		return parkingAreaRepository.save(parkingArea);
	}

	@Override
	public void delete(String areaId) throws ResourceNotFoundException {
		boolean isexist = parkingAreaRepository.existsById(areaId);
		if (!isexist) {
			throw new ResourceNotFoundException("ParkingArea not found with Id : " + areaId);
		}
		parkingAreaRepository.deleteById(areaId);
	}

	public Page<ParkingArea> getAll(Pageable pagable) {
		return parkingAreaRepository.findAll(pagable);
	}

	@Override
	public ParkingArea getById(String areaId) throws ResourceNotFoundException {
		return parkingAreaRepository.findById(areaId)
				.orElseThrow(() -> new ResourceNotFoundException("ParkingArea not found with Id : " + areaId));

	}

	@Override
	public Page<ParkingArea> getByCity(String city, Pageable pagable) {
		return parkingAreaRepository.findByAddressCity(city, pagable);
	}

	@Override
	public Page<ParkingArea> findNearByParkingArea(double latitude, double longitude, String range,Pageable pagable) {
		return  parkingAreaRepository.findByAddressLocationNear(latitude, longitude, range,pagable);
	}

}
