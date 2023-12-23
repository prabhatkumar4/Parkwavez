package com.example.parkingproviderservice.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.parkingproviderservice.model.ProviderDetails;

public interface ProviderDetailsRepository extends ElasticsearchRepository<ProviderDetails,String>{

}
