package com.example.reviewservice.services.Impl;

import com.example.reviewservice.entity.ReviewAndRating;
import com.example.reviewservice.repository.ReviewAndRatingRepository;
import com.example.reviewservice.services.ReviewAndRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ReviewAndRatingServiceImpl implements ReviewAndRatingService {

    @Autowired
    private ReviewAndRatingRepository reviewAndRatingRepository;

    @Override
    public ReviewAndRating addReviewAndRating(ReviewAndRating reviewAndRating) {
        reviewAndRating.setReviewId(UUID.randomUUID().toString().split("-")[0]);
        reviewAndRating.setReviewDateAndTime(new Date());
        return reviewAndRatingRepository.save(reviewAndRating);
    }

    @Override
    public List<ReviewAndRating> getReviewAndRatings() {
        return reviewAndRatingRepository.findAll();
    }

    @Override
    public List<ReviewAndRating> getReviewAndRatingByUserId(String userId) {
        return reviewAndRatingRepository.findByUserId(userId);
    }

    @Override
    public List<ReviewAndRating> getReviewAndRatingByProviderId(String providerId) {
        return reviewAndRatingRepository.findByProviderId(providerId);
    }

    @Override
    public List<ReviewAndRating> getReviewAndRatingByBookingId(String bookingId) {
        return reviewAndRatingRepository.findByBookingId(bookingId);
    }

    @Override
    public Long deleteByUserId(String userId) {

        return reviewAndRatingRepository.deleteByUserId(userId);
    }


}
