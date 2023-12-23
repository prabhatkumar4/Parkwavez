package com.example.notificationservice.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.notificationservice.model.NotificationModel;
import com.example.notificationservice.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService{

	 @Autowired
	    private NotificationRepository notificationRepository;
	
	 private final JavaMailSender mailSender;
	 
	 public NotificationServiceImpl(JavaMailSender mailSender) {
			super();
			this.mailSender = mailSender;
		}
	 
	@Override
	public List<NotificationModel> findBySpotId(String spotId) {
		return notificationRepository.findBySpotId(spotId);
	}

	@Override
	public void sendEmail(String email, String subject, String emailBody) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("parkwavez@gmail.com");
		simpleMailMessage.setTo(email);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(emailBody);
		
		this.mailSender.send(simpleMailMessage);
		
	}

}
