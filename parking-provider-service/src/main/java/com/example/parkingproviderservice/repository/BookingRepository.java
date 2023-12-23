package com.example.parkingproviderservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;

import com.example.parkingproviderservice.model.Booking;

public interface BookingRepository extends ElasticsearchRepository<Booking, String> {
    @Query("{\"bool\":{\"must\":{\"term\":{\"spotId\":\":spotId\"}},\"should\":[{\"range\":{\"checkInDateTime\":{\"gte\":\":startDate\",\"lte\":\":endDate\"}}},{\"range\":{\"checkOutDateTime\":{\"gte\":\":startDate\",\"lte\":\":endDate\"}}},{\"bool\":{\"must\":[{\"range\":{\"checkInDateTime\":{\"lte\":\":startDate\"}}},{\"range\":{\"checkOutDateTime\":{\"gte\":\":endDate\"}}}]} }]}}")
    List<Booking> getBooking(@Param("spotId") String parkingSpotId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
