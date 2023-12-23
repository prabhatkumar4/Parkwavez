package com.example.parkingspacebooking.kafkaProducerController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingspacebooking.Model.Booking;
import com.example.parkingspacebooking.producerService.KafkaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {
	
	 private KafkaProducer kafkaProducer;
	 public KafkaProducerController(KafkaProducer kafkaProducer) {
	        this.kafkaProducer = kafkaProducer;
	    }

	 @GetMapping("/post")
	    public ResponseEntity<String> publishpost(@RequestBody Booking booking) throws JsonProcessingException {
	    	kafkaProducer.bookingTopicPost(booking);
	        return ResponseEntity.ok("Message sent to kafka topic");
	    }
	    @GetMapping("/delete")
	    public ResponseEntity<String> publishdelete(@RequestBody Booking booking) throws JsonProcessingException {
	        kafkaProducer.bookingTopicDelete(booking);
	        return ResponseEntity.ok("Message sent to kafka topic");
	    }
	    @GetMapping("/update")
	    public ResponseEntity<String> publishupdate(@RequestBody Booking booking) throws JsonProcessingException {
	        kafkaProducer.bookingTopicUpdate(booking);
	        return ResponseEntity.ok("Message sent to kafka topic");
	    }
	 
	 
}
