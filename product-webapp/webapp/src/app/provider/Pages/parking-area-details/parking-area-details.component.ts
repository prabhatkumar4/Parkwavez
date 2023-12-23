import { Component, OnInit } from '@angular/core';
import { DataService } from '../../service/data-service.service';
import { ParkingArea } from '../../model/ParkingArea';
import { ParkingAreaService } from '../../service/parking-area.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-parking-area-details',
  templateUrl: './parking-area-details.component.html',
  styleUrls: ['./parking-area-details.component.css'],
})
export class ParkingAreaDetailsComponent implements OnInit {
  editingEnabled: boolean = false;
  parkingArea!: ParkingArea;
  parkingAreaId!: string | null;
  loading = false;
  error!: string;
  constructor(
    private dataService: DataService,
    private parkingAreaService: ParkingAreaService,
    private _router: Router,
    private acivatedRoute: ActivatedRoute
  ) {
    this.acivatedRoute.paramMap.subscribe((params) => {
      this.parkingAreaId = params.get('areaId');
    });
  }
  ngOnInit(): void {
    this.loading = true;
    this.parkingArea = this.dataService.parkingArea;
    if (!this.parkingArea) {
      if (!this.parkingAreaId) {
        this._router.navigate(['provider']);
      } else {
        this.parkingAreaService
          .getParkingAreaById(this.parkingAreaId)
          .subscribe(
            (res) => {
              this.dataService.parkingArea = res;
              this.parkingArea = res;
            },
            (err) => {
              this.error = err.message;
            }
          );
      }
    }
    this.loading = false;
  }

  OnUpdate() {
    this.parkingAreaService.updateParkingSpace(this.parkingArea).subscribe(
      (updatedParkingSpace: ParkingArea) => {
        console.log(updatedParkingSpace);
        this.dataService.parkingArea = updatedParkingSpace;
        this.toggleEditing();
      },
      () => {}
    );
  }
  toggleEditing() {
    this.editingEnabled = !this.editingEnabled;
  }
}
