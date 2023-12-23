import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../service/review.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthenticationService } from '../authentication.service';
import { MatDialogRef } from '@angular/material/dialog';


@Component({
  selector: 'app-review-form',
  templateUrl: './review-form.component.html',
  styleUrls: ['./review-form.component.css']
})
export class ReviewFormComponent {

  bookingId: string='';
  rating: number | null = null;
  reviewDesc: string='';
  userId: string='';
  providerId: string='';

  constructor(private reviewService: ReviewService,
    private router: Router,
    private snackBar: MatSnackBar, private authenticationService: AuthenticationService, public dialogRef: MatDialogRef<ReviewFormComponent>,) {

    }



  submitReview() {
    const reviewData = {
      bookingId: this.bookingId,
      rating: this.rating,
      reviewDesc: this.reviewDesc,
      userId: this.userId,
      providerId: this.providerId
    };

    // Call the service method to submit the review data
    this.reviewService.submitReview(reviewData).subscribe(
      (response) => {
         // Handle success (e.g., show a success snackbar message)
      this.showSuccessSnackbar('Review submitted successfully!');
        // Handle success (e.g., show a success message)
        console.log('Review submitted successfully:', response);
      },
      (error) => {
         // Handle error (e.g., show an error message)
        console.error('Error submitting review:', error);
      }
    );
  }

  private showSuccessSnackbar(message: string) {
    this.snackBar.open(message, 'Close', {
      duration: 3000, // Adjust the duration as needed (in milliseconds)
      horizontalPosition: 'center', // Position the snackbar message
      verticalPosition: 'top',
      panelClass: ['success-snackbar'], // Optional CSS class for styling
    });
  }

  onClose(): void {
    this.dialogRef.close();
  }

  cancelReview() {
    this.router.navigate(['/review']);
    this.onClose();
  }

  submitClose() {
    this.router.navigate(['/review']);
    this.onClose();
  }

}
