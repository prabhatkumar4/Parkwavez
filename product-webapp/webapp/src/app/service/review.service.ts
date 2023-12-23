import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ReviewFormComponent } from '../review-form/review-form.component';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_GATEWAY } from '../api';

@Injectable({
  providedIn: 'root',
})
export class ReviewService {
  private apiUrl = API_GATEWAY; // Adjust the API URL

  constructor(private dialog: MatDialog, private http: HttpClient) {}

  openReviewForm() {
    this.dialog.open(ReviewFormComponent, {
      width: '400px', // Adjust the width as needed
    });
  }
  // Add the submitReview method
  submitReview(reviewData: any) {
    // Implement your logic to submit the review here (e.g., send to a backend API).
    return this.http.post(`${this.apiUrl}/reviewAndRating`, reviewData);
  }

  public getReviews() {
    return this.http.get(this.apiUrl + '/reviewAndRating');
  }

  public getReviewsByProviderId(providerId: number) {
    return this.http.get(
      this.apiUrl + '/reviewAndRating/providers/' + providerId
    );
  }

  public deleteReview(userId: any) {
    return this.http.delete(this.apiUrl + '/reviewAndRating/delete/' + userId);
  }
}
