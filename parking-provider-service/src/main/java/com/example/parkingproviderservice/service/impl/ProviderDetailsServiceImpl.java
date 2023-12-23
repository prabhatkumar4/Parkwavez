package com.example.parkingproviderservice.service.impl;

import com.example.parkingproviderservice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.parkingproviderservice.model.ProviderDetails;
import com.example.parkingproviderservice.repository.ProviderDetailsRepository;
import com.example.parkingproviderservice.service.ProviderDetailsService;
import com.example.parkingproviderservice.util.JacksonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProviderDetailsServiceImpl implements ProviderDetailsService {
	@Autowired
	private ProviderDetailsRepository providerRepository;
	ObjectMapper objectMapper = JacksonFactory.getObjectMapper();

	@Override
	@KafkaListener(topics = "user-registration-topic", groupId = "14")
	public void saveProviderDetails(String message) throws JsonMappingException, JsonProcessingException {
		ProviderDetails providerDetails = objectMapper.readValue(message, ProviderDetails.class);
		System.out.println(providerDetails.toString());
		providerRepository.save(providerDetails);
	}


	@Override
	public ProviderDetails getProviderById(String providerId) throws ResourceNotFoundException {
		return providerRepository.findById(providerId).orElseThrow(()->new ResourceNotFoundException("Provider Not found with Id : "+providerId));
	}

	@Override
	public ProviderDetails updateProviderDetails(ProviderDetails updatedProviderDetails) throws ResourceNotFoundException {
		ProviderDetails provider=providerRepository.findById(updatedProviderDetails.getUserId()).orElse(null);
		if(provider==null){
			throw new ResourceNotFoundException("Provider Not found with Id : "+updatedProviderDetails.getUserId());
		}
		provider.setUserName(updatedProviderDetails.getUserName());
		provider.setEmail(updatedProviderDetails.getEmail());
		provider.setRole(updatedProviderDetails.getRole());
		provider.setAddress(updatedProviderDetails.getAddress());
		return providerRepository.save(provider);
	}
	@Override
	public ProviderDetails updateProfilePicture(String userId, MultipartFile file) throws ResourceNotFoundException, IOException {
		ProviderDetails provider = providerRepository.findById(userId).orElse(null);
		if (provider == null) {
			throw new ResourceNotFoundException("Provider Not found with Id : " + userId);
		}
		provider.setImage(file.getBytes());
		return providerRepository.save(provider);

	}

	@Override
	public void deleteProviderDetails(String providerId) throws ResourceNotFoundException{
		if(!providerRepository.existsById(providerId)){
			throw new ResourceNotFoundException("Provider Not found with Id : "+providerId);
		}
		providerRepository.deleteById(providerId);
	}
}
