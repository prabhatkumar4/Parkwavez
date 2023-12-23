package com.example.notificationservice.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.notificationservice.model.NotificationModel;

@Service
public interface NotificationService {
	
	public List<NotificationModel> findBySpotId(String spotId);

    public void sendEmail(String email, String subject, String emailBody);

}
