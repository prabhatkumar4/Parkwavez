package com.example.notificationservice.consumer;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.notificationservice.exception.MessageProcessingException;
import com.example.notificationservice.service.NotificationService;
import com.kafkaProducer.UserDTO;
import com.kafkaProducer.UserSpotIdDTO;
import com.kafkaProducer.BookingDTO;

@Service
public class KafkaMessageListener {

    org.slf4j.Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);
    
    @Autowired
	private NotificationService notificationService;
    
    @KafkaListener(topics = "user-registration-topic", groupId = "group14")
    public void consume(UserDTO user) {
    	try {
        log.info("consumer consume {}", user);
        String emailBody = "Dear " + user.getUserName() + " Your Application Created with User Id " + user.getUserId() + " .";
        notificationService.sendEmail(user.getEmail(), "Account Successfully Created", emailBody);
    	} catch (Exception ex) {
    		log.error("Error processing Kafka message for user: {}", user, ex);
            throw new MessageProcessingException("Error processing Kafka message for user: " + user, ex);
    	}
    }
    
    @KafkaListener(topics = "vacancyCreated2", groupId = "group14")
    public void consume2(UserSpotIdDTO user2) {
    	try {
        log.info("consumer consume {}", user2);        
        String emailBody = "Dear " + user2.getUserName() + " spot ID " + user2.getSpotId() + " is now available for booking.";
        notificationService.sendEmail(user2.getUserEmail(), "Your Subscribed Spot is now available for Booking", emailBody);
    	} catch (Exception ex) {
    		log.error("Error processing Kafka message for user: {}", user2, ex);
            throw new MessageProcessingException("Error processing Kafka message for user: " + user2, ex);
    	}
    }
    
    @KafkaListener(topics = "bookingNotification", groupId = "group14")
    public void consume3(BookingDTO user3) {
    	try {
    	 System.out.println("Email : " + user3.getEmailId());
    	 String emailBody = "Dear ,"+ user3.getUserId() + ". This is Your Booking Info :\n\n" +
    	                     "Spot Id: " + user3.getSpotId() + "\nBooking Date: "+ user3.getBooking_date() + "\nCheck In Time : " + user3.getCheck_In()
    	                     + "\nCheck Out Time : " + user3.getCheck_Out() + "\nAmount:" + user3.getAmount()
    	                     + "\nBooking Status : " + user3.getStatus();
    	 notificationService.sendEmail(user3.getEmailId(),"Booking Information", emailBody);
    	} catch (Exception ex) {
    		log.error("Error processing Kafka message for user: {}", user3, ex);
            throw new MessageProcessingException("Error processing Kafka message for user: " + user3, ex);
    	}
    }
    
}

