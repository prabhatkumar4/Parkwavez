package com.example.parkingproviderservice.model;

import java.time.LocalDateTime;
import java.util.Date;

import com.example.parkingproviderservice.dto.BookingDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "booking")
public class Booking {
	@Id
	private String bookingId;
	private String userId;
	private String spotId;
	@Field(type = FieldType.Date,format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
	private Date bookingDate;
	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
	private LocalDateTime checkInDateTime;
	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
	private LocalDateTime checkOutDateTime;
	private String status;
	private double amount;
	public Booking(BookingDto bookingDto){
		this.bookingId=bookingDto.getBookingId();
		this.userId=bookingDto.getUserId();
		this.bookingDate=bookingDto.getBooking_date();
		this.checkInDateTime=bookingDto.getCheck_In();
		this.checkOutDateTime=bookingDto.getCheck_Out();
		this.status=bookingDto.getStatus();
		this.amount=bookingDto.getAmount();
	}
}

