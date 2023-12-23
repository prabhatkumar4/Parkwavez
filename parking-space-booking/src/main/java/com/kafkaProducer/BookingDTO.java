package com.kafkaProducer;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BookingDTO {
	private String bookingId;
	private String userId;
	private String spotId;
	 private Date Booking_date;
	 private LocalDateTime Check_In;
	 private LocalDateTime Check_Out;
	 private String status;
	 private String emailId;
	 private double amount;
	 
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
	@Override
	public String toString() {
		return "BookingDTO [bookingId=" + bookingId + ", userId=" + userId + ", spotId=" + spotId + ", Booking_date="
				+ Booking_date + ", Check_In=" + Check_In + ", Check_Out=" + Check_Out + ", status=" + status
				+ ", emailId=" + emailId + ", amount=" + amount + "]";
	}
	 
	 
}

