import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booking } from './booking';
import { Observable, BehaviorSubject } from 'rxjs';
import { API_GATEWAY } from './api';

@Injectable({
  providedIn: 'root',
})
export class BookingDataService {
  private baseURL = `${API_GATEWAY}/Booking`;
  constructor(private httpClient: HttpClient) {}

  getBookingList(): Observable<Booking[]> {
    // alert(this.baseURL)
    return this.httpClient.get<Booking[]>(`${this.baseURL}`);
  }
  submitBooking(bookingData: any) {
    // Implement your logic to submit the review here (e.g., send to a backend API).

    return this.httpClient.post(`${this.baseURL}`, bookingData);
  }

  private dataSubject = new BehaviorSubject<any>({});

  setData(data: any): void {
    this.dataSubject.next(data);
  }

  getData(): Observable<any> {
    return this.dataSubject.asObservable();
  }

  //private bookingData:any;

  //setBookingData(data:any){
  //this.bookingData=data;
  //}

  //getBookingData(){
  //return this.bookingData;
  //}
}
