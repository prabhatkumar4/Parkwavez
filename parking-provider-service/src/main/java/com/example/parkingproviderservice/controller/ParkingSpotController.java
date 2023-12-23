package com.example.parkingproviderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingproviderservice.dto.BookingTimeRangeDto;
import com.example.parkingproviderservice.exception.ResourceNotFoundException;
import com.example.parkingproviderservice.model.ParkingSpot;
import com.example.parkingproviderservice.model.SpotType;
import com.example.parkingproviderservice.service.ParkingSpotService;

@RestController
@RequestMapping("/parking-spot")
@CrossOrigin(maxAge = 3600)
public class ParkingSpotController {
	@Autowired
	private ParkingSpotService parkingSpotService;

	@PostMapping("/provider/{areaId}/add")
	public ResponseEntity<ParkingSpot> addParkingSpot(@PathVariable String areaId, @RequestBody ParkingSpot parkingSpot)
			throws ResourceNotFoundException {
		parkingSpot = parkingSpotService.addParkingSpot(areaId, parkingSpot);
		return ResponseEntity.ok(parkingSpot);
	}

	@GetMapping("/public/get-by-area/{areaId}")
	public ResponseEntity<List<ParkingSpot>> getParkingSpotByParkingArea(@PathVariable String areaId)
			throws ResourceNotFoundException {
		List<ParkingSpot> spots = parkingSpotService.getParkingSpotByParkingArea(areaId);
		return ResponseEntity.ok(spots);
	}

	@GetMapping("/public/get-by-id/{spotId}")
	public ResponseEntity<ParkingSpot> getParkingSpotById(@PathVariable String spotId)
			throws ResourceNotFoundException {
		ParkingSpot parkingSpot = parkingSpotService.getParkingSpotById(spotId);
		return ResponseEntity.ok(parkingSpot);
	}

	@GetMapping("/public/get-by-number/{areaId}/{spotNumber}")
	public ResponseEntity<ParkingSpot> getParkingSpotByNumber(@PathVariable String areaId, @PathVariable int spotNumber)
			throws ResourceNotFoundException {
		ParkingSpot parkingSpot = parkingSpotService.getParkingSpotByNumber(areaId, spotNumber);
		return ResponseEntity.ok(parkingSpot);
	}

	@GetMapping("/public/get-by-type/{areaId}/{spotType}")
	public ResponseEntity<List<ParkingSpot>> getParkingSpotBySpotType(@PathVariable String areaId,
			@PathVariable SpotType spotType) throws ResourceNotFoundException {
		List<ParkingSpot> parkingSpot = parkingSpotService.getParkingSpotBySpotType(areaId, spotType);
		return ResponseEntity.ok(parkingSpot);
	}

	@PutMapping("/provider/update/{spotId}")
	public ResponseEntity<ParkingSpot> updateParkingSpot(@PathVariable String spotId,
			@RequestBody ParkingSpot parkingSpot) throws ResourceNotFoundException {
		System.out.println(parkingSpot);
		parkingSpot.setParkingSpotId(spotId);
		parkingSpot = parkingSpotService.updateParkingSpot(parkingSpot);
		System.out.println(parkingSpot);
		return ResponseEntity.ok(parkingSpot);
	}

	@DeleteMapping("/provider/delete/{spotId}")
	public ResponseEntity<String> delteParkingSpot(@PathVariable String spotId) throws ResourceNotFoundException {
		parkingSpotService.delteParkingSpot(spotId);
		return ResponseEntity.ok("{\"message\": \"Deleted\"}");
	}

	@GetMapping("public/{parkingAreaId}/get-vaccant-space")
	ResponseEntity<List<ParkingSpot>> getVaccantSpot(@PathVariable String parkingAreaId,
			@RequestBody BookingTimeRangeDto bookingTimeRangeDto,@RequestParam(required = false) SpotType spotType) throws Exception {
		List<ParkingSpot> spots = parkingSpotService.getVaccantSpot(parkingAreaId, bookingTimeRangeDto,spotType);
		return ResponseEntity.ok(spots);
	}

	@GetMapping("public/{parkingSpotId}/get-spot-status")
	ResponseEntity<Boolean> getSpotStatus(@PathVariable String parkingSpotId,
			@RequestBody BookingTimeRangeDto bookingTimeRangeDto) {
		boolean vaccant = parkingSpotService.isOccupied(parkingSpotId, bookingTimeRangeDto);
		return ResponseEntity.ok(vaccant);
	}
}
