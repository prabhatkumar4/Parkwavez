package com.example.parkingproviderservice.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.parkingproviderservice.model.ChargeType;
import com.example.parkingproviderservice.model.Price;
import com.example.parkingproviderservice.model.SpotType;

@Repository
public interface PriceRepository extends ElasticsearchRepository<Price,String> {
	List<Price> findByAreaIdAndSpotTypeAndChargeType(String areaId,SpotType spotype,ChargeType chargeType);
	List<Price> findByAreaIdAndChargeType(String areaId, ChargeType chargeType);
	List<Price> findByAreaIdAndSpotType(String areaId,SpotType spotype);
	List<Price> findByAreaId(String areaId);
}
