package com.example.parkingproviderservice.service.impl;

import com.example.parkingproviderservice.dto.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.parkingproviderservice.model.Booking;
import com.example.parkingproviderservice.repository.BookingRepository;
import com.example.parkingproviderservice.service.BookingService;
import com.example.parkingproviderservice.util.JacksonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	ObjectMapper objectMapper = JacksonFactory.getObjectMapper();
	@Override
	@KafkaListener(topics = "bookingservicepost", groupId = "bookinggroup")
	public void bookingTopicPost(String message) throws JsonMappingException, JsonProcessingException {
		BookingDto bookingDto = objectMapper.readValue(message, BookingDto.class);
		Booking booking=new Booking(bookingDto);
		booking = bookingRepository.save(booking);
	}

	@Override
	@KafkaListener(topics = "bookingservicedelete", groupId = "bookinggroup")
	public void bookingTopicDeletet(String message) throws JsonMappingException, JsonProcessingException {
		Booking booking = objectMapper.readValue(message, Booking.class);
		bookingRepository.deleteById(booking.getBookingId());
	}

	@Override
	@KafkaListener(topics = "bookingserviceupdate", groupId = "bookinggroup")
	public void bookingTopicUpdate(String message) throws JsonMappingException, JsonProcessingException {
		Booking booking = objectMapper.readValue(message, Booking.class);
		bookingRepository.save(booking);
	}

}
