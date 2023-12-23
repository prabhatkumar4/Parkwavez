package com.example.reviewservice.controllers;

import com.example.reviewservice.entity.ReviewAndRating;
import com.example.reviewservice.exceptions.GetReviewAndRatingException;
import com.example.reviewservice.exceptions.NoDataFoundException;
import com.example.reviewservice.exceptions.ReviewAndRatingException;
import com.example.reviewservice.services.ReviewAndRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reviewAndRating")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ReviewAndRatingController {

    @Autowired
    private ReviewAndRatingService reviewAndRatingService;


    //create rating
    @PostMapping
    public ResponseEntity<ReviewAndRating> create(@Valid @RequestBody ReviewAndRating reviewAndRating) {
        try {
            // Code to add the review and rating
            ReviewAndRating savedReview = reviewAndRatingService.addReviewAndRating(reviewAndRating);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedReview);
        } catch (Exception e) {
            throw new ReviewAndRatingException("Failed to create review and rating: " + e.getMessage());
        }
    }



    //get all
    @GetMapping
    public ResponseEntity<?> getReviewAndRatings(){
        try {
            List<ReviewAndRating> reviewAndRatings = reviewAndRatingService.getReviewAndRatings();

            if (reviewAndRatings.isEmpty()) {
                throw new NoDataFoundException("No review and ratings data found.");
            }

            return ResponseEntity.ok(reviewAndRatings);
        } catch (Exception e) {
            throw new GetReviewAndRatingException("Failed to retrieve review and ratings: " + e.getMessage());
        }
    }


    //get all by userId
    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getReviewAndRatingsByUserId(@PathVariable String userId) {
        try {
            List<ReviewAndRating> reviewAndRatings = reviewAndRatingService.getReviewAndRatingByUserId(userId);

            if (reviewAndRatings.isEmpty()) {
                throw new NoDataFoundException("No review and ratings data found for user ID: " + userId);
            }

            return ResponseEntity.ok(reviewAndRatings);
        } catch (Exception e) {
            throw new GetReviewAndRatingException("Failed to retrieve review and ratings by user ID: " + e.getMessage());
        }
    }

    //get all by bookingId
    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<?> getReviewAndRatingsByBookingId(@PathVariable String bookingId) {
        try {
            List<ReviewAndRating> reviewAndRatings = reviewAndRatingService.getReviewAndRatingByBookingId(bookingId);

            if (reviewAndRatings.isEmpty()) {
                throw new NoDataFoundException("No review and ratings data found for booking ID: " + bookingId);
            }

            return ResponseEntity.ok(reviewAndRatings);
        } catch (Exception e) {
            throw new GetReviewAndRatingException("Failed to retrieve review and ratings by booking ID: " + e.getMessage());
        }
    }

    //get all by providerId
    @GetMapping("/providers/{providerId}")
    public ResponseEntity<?> getReviewAndRatingsByProviderId(@PathVariable String providerId) {
        try {
            List<ReviewAndRating> reviewAndRatings = reviewAndRatingService.getReviewAndRatingByProviderId(providerId);

            if (reviewAndRatings.isEmpty()) {
                throw new NoDataFoundException("No review and ratings data found for provider ID: " + providerId);
            }

            return ResponseEntity.ok(reviewAndRatings);
        } catch (Exception e) {
            throw new GetReviewAndRatingException("Failed to retrieve review and ratings by provider ID: " + e.getMessage());
        }
    }



    //delete review and rating by userId
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteReviewsByUserId(@PathVariable String userId) {
        try {
            // Call the service method to delete reviews and ratings by user ID
            Long l = reviewAndRatingService.deleteByUserId(userId);
            if(l==0L){return new ResponseEntity<>("UserId "+userId+" Does not exist",HttpStatus.NOT_FOUND);}
            else{
                return new ResponseEntity<>("Review and ratings deleted successfully of userId: "+userId, HttpStatus.OK);
            }
        } catch (Exception e) {
            // Handle exceptions or errors, and return an appropriate response
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
