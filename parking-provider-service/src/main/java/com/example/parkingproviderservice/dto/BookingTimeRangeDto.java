package com.example.parkingproviderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingTimeRangeDto {
	private String checkInDateTime;
	private String checkOutDateTime;
}
