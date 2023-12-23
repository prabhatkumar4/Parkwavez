package com.example.parkingproviderservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.parkingproviderservice.model.ParkingArea;

@Repository
public interface ParkingAreaRepository extends ElasticsearchRepository<ParkingArea, String> {
	Page<ParkingArea> findByProviderId(long providerId, Pageable pageable);

	Page<ParkingArea> findByAddressCity(String city, Pageable pageable);

	@Query("{\"bool\" : {\"must\" : {\"match_all\" : {}},\"filter\" : {\"geo_distance\" : {\"distance\" : \"?2\", \"address.location\" : {\"lat\" : ?0, \"lon\" : ?1}}}}}")
	Page<ParkingArea> findByAddressLocationNear(double latitude, double longitude, String distance, Pageable pageable);
}
