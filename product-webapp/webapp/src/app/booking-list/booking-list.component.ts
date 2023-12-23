import { Component,OnInit } from '@angular/core';
import{ Booking} from '../booking';
import { BookingDataService } from '../booking-data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.css']
})
export class BookingListComponent implements OnInit{

 bookings: Booking[]=[];

  constructor(private bookingDataService: BookingDataService,
    private router:Router){}
  ngOnInit(): void {
    this.getBooking();
}
private getBooking(){
  this.bookingDataService.getBookingList().subscribe(data =>{
    this.bookings=data;
  });

  
}
submitBooking() {

}

navigateToReview(){
  this.router.navigate(['/review']);
}


}
