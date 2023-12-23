import { Component, Inject, OnInit } from '@angular/core';
import { ReviewService } from '../service/review.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-review-list-form',
  templateUrl: './review-list-form.component.html',
  styleUrls: ['./review-list-form.component.css']
})
export class ReviewListFormComponent implements OnInit{

  // reviews: any[] = [];
  reviewDetails: any;
  providerId!: number;

  ngOnInit() {
  }

  constructor(private reviewService: ReviewService,
    public dialogRef: MatDialogRef<ReviewListFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: number){
      this.getAllReviewsByProviderId(data);
    }


  getAllReviewsByProviderId(providerId: number) {
    this.reviewService.getReviewsByProviderId(providerId).subscribe(
      (resp)=> {
        console.log(resp);
        this.reviewDetails = resp;
      },
      (err) => {
        console.log(err);
      }
    );
  }


}

