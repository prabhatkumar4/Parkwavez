package com.example.parkingspacebooking.producerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.parkingspacebooking.Model.Booking;
import com.example.parkingspacebooking.Model.JacksonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaProducer {

    ObjectMapper objectMapper = JacksonFactory.getObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, Booking> kafkaTemplate;

    public void bookingTopicPost(Booking booking) throws JsonProcessingException {
        LOGGER.info(String.format("\nMessage sent -> %s", booking.toString()));
        kafkaTemplate.send("bookingservicepost", booking);
    }

    public void bookingTopicDelete(Booking booking) throws JsonProcessingException {
        LOGGER.info(String.format("\nMessage sent -> %s", booking.toString()));
        kafkaTemplate.send("bookingservicedelete", booking);
    }

    public void bookingTopicUpdate(Booking booking) throws JsonProcessingException {
        LOGGER.info(String.format("\nMessage sent -> %s", booking.toString()));
        kafkaTemplate.send("bookingserviceupdate", booking);
    }

}
