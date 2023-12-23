package com.example.parkingproviderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface BookingService {
	public void bookingTopicPost(String message)throws JsonMappingException, JsonProcessingException;
	public void bookingTopicDeletet(String message)throws JsonMappingException, JsonProcessingException;
	public void bookingTopicUpdate(String message)throws JsonMappingException, JsonProcessingException;
}
