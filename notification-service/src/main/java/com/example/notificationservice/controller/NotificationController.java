package com.example.notificationservice.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.notificationservice.model.NotificationModel;
import com.example.notificationservice.repository.NotificationRepository;
import com.example.notificationservice.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private NotificationRepository notificationRepository;

	@GetMapping("/send-email/{spotId}")
	@ResponseStatus(value = HttpStatus.OK)
	public void sendEmail(@PathVariable String spotId) {
		List<NotificationModel> notifications = notificationRepository.findBySpotId(spotId);
		notifications.forEach(notification -> {
			if(notification.getNotificationMsgType().equals("vacancyCreated")) {
			String emailBody = "Dear user, parking is available in SpotId " + spotId + " for booking.";
			notificationService.sendEmail(notification.getEmail(), "Parking Available", emailBody);
			}
		});

	}

}
