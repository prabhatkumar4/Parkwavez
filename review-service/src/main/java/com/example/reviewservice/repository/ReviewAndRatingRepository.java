package com.example.reviewservice.repository;

import com.example.reviewservice.entity.ReviewAndRating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewAndRatingRepository extends MongoRepository<ReviewAndRating,String>
{
    //custom finder methods
    List<ReviewAndRating> findByUserId(String userId);
    List<ReviewAndRating> findByBookingId(String bookingId);
    List<ReviewAndRating> findByProviderId(String providerId);
    Long deleteByUserId(String userId);

}
