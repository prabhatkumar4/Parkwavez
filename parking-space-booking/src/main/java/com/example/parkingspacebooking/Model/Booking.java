package com.example.parkingspacebooking.Model;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Document(collection = "Booking")
public class Booking {
	
	@Id
	private String bookingId;
	private String userId;
	private String spotId;
	 private Date Booking_date;
	 private LocalDateTime Check_In;
	 private LocalDateTime Check_Out;
	 private String status;
	 private String emailId;
	 private double amount;

	@Override
	public String toString() {
		return "Booking{" +
				"bookingId='" + bookingId + '\'' +
				", userId='" + userId + '\'' +
				", spotId='" + spotId + '\'' +
				", Booking_date=" + Booking_date +
				", Check_In=" + Check_In +
				", Check_Out=" + Check_Out +
				", status='" + status + '\'' +
				", emailId='" + emailId + '\'' +
				", amount=" + amount +
				'}';
	}

	public Booking() {
	}

	public Booking(String bookingId, String userId, String spotId, Date booking_date, LocalDateTime check_In, LocalDateTime check_Out, String status, String emailId, double amount) {
		this.bookingId = bookingId;
		this.userId = userId;
		this.spotId = spotId;
		Booking_date = booking_date;
		Check_In = check_In;
		Check_Out = check_Out;
		this.status = status;
		this.emailId = emailId;
		this.amount = amount;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSpotId() {
		return spotId;
	}

	public void setSpotId(String spotId) {
		this.spotId = spotId;
	}

	public Date getBooking_date() {
		return Booking_date;
	}

	public void setBooking_date(Date booking_date) {
		Booking_date = booking_date;
	}

	public LocalDateTime getCheck_In() {
		return Check_In;
	}

	public void setCheck_In(LocalDateTime check_In) {
		Check_In = check_In;
	}

	public LocalDateTime getCheck_Out() {
		return Check_Out;
	}

	public void setCheck_Out(LocalDateTime check_Out) {
		Check_Out = check_Out;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
