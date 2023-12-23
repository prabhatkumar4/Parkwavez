import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../service/review.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-review-list',
  templateUrl: './review-list.component.html',
  styleUrls: ['./review-list.component.css']
})
export class ReviewListComponent implements OnInit {
  reviews: any[] = [];


  reviewDetails: any;



  constructor(private reviewService: ReviewService) {

  }



  ngOnInit() {
    this.getAllReviews();

  }



  getAllReviews() {
    this.reviewService.getReviews().subscribe(
      (resp)=> {
        console.log(resp);
        this.reviewDetails = resp;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  deleteReview(review: any) {
    this.reviewService.deleteReview(review.userId).subscribe(
      (resp) => {
        console.log(resp);
      },
      (err) => {
        console.log(err);
      }
    );
  }

}
