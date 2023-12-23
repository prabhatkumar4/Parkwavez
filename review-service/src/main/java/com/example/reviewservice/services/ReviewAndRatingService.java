package com.example.reviewservice.services;

import com.example.reviewservice.entity.ReviewAndRating;

import java.util.List;

public interface ReviewAndRatingService {
    //create
    public ReviewAndRating addReviewAndRating(ReviewAndRating reviewAndRating);

    //get all ratings
    public List<ReviewAndRating> getReviewAndRatings();

    //get all ratings by userId
    public List<ReviewAndRating> getReviewAndRatingByUserId(String userId);

    //get all ratings by providerId
    public List<ReviewAndRating> getReviewAndRatingByProviderId(String providerId);

    //get all ratings by bookingId
    public  List<ReviewAndRating> getReviewAndRatingByBookingId(String bookingId);

    //delete ratings by userId
    public Long deleteByUserId(String userId);

}
