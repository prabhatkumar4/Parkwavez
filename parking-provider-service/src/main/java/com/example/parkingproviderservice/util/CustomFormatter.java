package com.example.parkingproviderservice.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CustomFormatter {
	public static String format(LocalDateTime dateTime) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
			return dateTime.format(formatter);
		} catch (DateTimeParseException e) {
			throw new DateTimeParseException("Give time in format yyyy-MM-dd'T'HH:mm:ss.SSSSSS", null, 0);
		}
	}
}
