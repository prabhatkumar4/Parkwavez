package com.example.notificationservice.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "notificationVacancyCreated")
public class NotificationModel {
	
	@Id
	private BigInteger userId;
	private String userName;
	private String email;
//	String sub;
	private String notificationMsgType; // for vacancy created notification notificationMsgType = "vacancyCreated"
	private String spotId;
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNotificationMsgType() {
		return notificationMsgType;
	}
	public void setNotificationMsgType(String notificationMsgType) {
		this.notificationMsgType = notificationMsgType;
	}
	public String getSpotId() {
		return spotId;
	}
	public void setSpotId(String spotId) {
		this.spotId = spotId;
	}
	

	
}
