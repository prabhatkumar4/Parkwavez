import { Component, OnInit } from '@angular/core';
import { ParkingAreaService } from '../../service/parking-area.service';
import { ParkingArea } from '../../model/ParkingArea';
import { AuthenticationService } from 'src/app/authentication.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  parkingAreas: ParkingArea[] = [];
  providerId = '1';
  message!: string;
  error!: string;
  dataSubscription!: Subscription;
  constructor(
    private _parkingAreaService: ParkingAreaService,
    private authService: AuthenticationService
  ) {
    this.dataSubscription = this.authService.user.subscribe((user) => {
      this.providerId = user.userId;
    });
  }
  ngOnInit(): void {
    this.getParkingAreas(this.providerId);
  }
  getParkingAreas(providerId: string) {
    this._parkingAreaService.getParkingSpace(providerId).subscribe(
      (parkingAreas: any) => {
        this.parkingAreas = parkingAreas.content;
      },
      (error) => {
        this.error = error.message;
      }
    );
  }
  deleteParkingArea(areaId: string) {
    this._parkingAreaService.deleteParkingSpace(areaId).subscribe(
      (message: any) => {
        this.message = message;
        this.parkingAreas = this.parkingAreas.filter(
          (parkingarea: ParkingArea) => {
            return parkingarea.areaId != areaId;
          }
        );
      },
      (err) => {
        console.log('error', err);
        this.error = err;
      }
    );
  }
}
