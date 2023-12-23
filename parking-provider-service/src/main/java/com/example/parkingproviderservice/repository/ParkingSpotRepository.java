package com.example.parkingproviderservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.parkingproviderservice.model.ParkingSpot;
import com.example.parkingproviderservice.model.SpotType;

@Repository
public interface ParkingSpotRepository extends ElasticsearchRepository<ParkingSpot,String> {
	List<ParkingSpot> findByParkingAreaId(String parkingAreaId);
	Optional<ParkingSpot> findByParkingAreaIdAndParkingSpotNumber(String parkingAreaId, int parkingSpotNumber);
	List<ParkingSpot> findByParkingAreaIdAndSpotType(String parkingAreaId, SpotType spotType);
	Page<ParkingSpot> findByParkingAreaId(String parkingAreaId, Pageable pageable);
}
