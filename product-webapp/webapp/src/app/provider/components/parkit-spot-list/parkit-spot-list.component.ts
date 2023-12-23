import { Component, Input, OnInit } from '@angular/core';
import { ParkingSpotService } from '../../service/parking-spot.service';
import { ParkingSpot } from '../../model/ParkingSpot';
import { MatDialog } from '@angular/material/dialog';
import { EditSpotComponent } from '../edit-spot/edit-spot.component';

@Component({
  selector: 'app-parkit-spot-list',
  templateUrl: './parkit-spot-list.component.html',
  styleUrls: ['./parkit-spot-list.component.css'],
})
export class ParkitSpotListComponent implements OnInit {
  @Input() areaId!: string;
  spotTypes = ['TwoWheeler', 'FourWheeler', 'BigVehicle', 'Handicap'];
  filteredParkingSpots: ParkingSpot[] = [];
  parkingSpots: ParkingSpot[] = [];
  error!: string |null;
  spotType!: string;
  sortField: keyof ParkingSpot = 'parkingSpotNumber';
  sortOptions = [
    { key: 'Occupied', value: 'occupied' },
    { key: 'Spot Number', value: 'parkingSpotNumber' },
    { key: 'Spot Type', value: 'spotType' },
  ];
  filterField!: string;
  filterOptions = ['TwoWheeler', 'FourWheeler', 'BigVehicle', 'Handicap', null];
  isMenuOpen = true;

  constructor(
    private parkingSpotService: ParkingSpotService,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.getParkingSpots();
  }
  filterEvent() {
    this.sortField = 'parkingSpotNumber';
    if (this.filterField == null) {
      this.filteredParkingSpots = this.parkingSpots;
      return;
    }
    this.filteredParkingSpots = this.parkingSpots.filter((spot) => {
      return spot.spotType == this.filterField;
    });
  }
  sortEvent() {
    this.filteredParkingSpots.sort((a, b) => {
      const fieldA = a[this.sortField];
      const fieldB = b[this.sortField];
      if (fieldA < fieldB) {
        return -1;
      } else if (fieldA > fieldB) {
        return 1;
      } else {
        return 0;
      }
    });
    this.filteredParkingSpots = [...this.filteredParkingSpots];
  }

  getParkingSpots() {
    this.parkingSpotService.getParkingSpots(this.areaId).subscribe(
      (parkingSpots: ParkingSpot[]) => {
        this.filteredParkingSpots = parkingSpots;
        this.sortEvent();
        this.parkingSpots = this.filteredParkingSpots;
      },
      (err) => {
        this.error = err.message;
      }
    );
  }
  addParkingSpots() {
    if (!this.spotType) {
      alert('Parking Spot Type Can not be empty!');
      return;
    }
    if (!this.areaId) {
      alert('Something went wrong!');
      return;
    }
    let newParkingSpot: ParkingSpot = {
      parkingSpotId: '',
      parkingSpotNumber: 0,
      occupied: false,
      spotType: this.spotType,
      parkingAreaId: this.areaId,
    };
    this.parkingSpotService.addPArkingSpot(newParkingSpot).subscribe((spot) => {
      this.parkingSpots.push(spot);
      if (spot.spotType === this.filterField) {
        this.filteredParkingSpots.push(spot);
      }
    });
  }

  openDrawer(parkingSpot: ParkingSpot) {
    const dialogRef = this.dialog.open(EditSpotComponent, {
      data: { parkingSpot },
      enterAnimationDuration: '200ms',
      exitAnimationDuration: '200ms',
    });

    dialogRef.afterClosed().subscribe((updatedParkingSpot: ParkingSpot) => {
      if (updatedParkingSpot) {
        this.filteredParkingSpots = this.filteredParkingSpots.map(
          (parkingSpot) => {
            if (
              parkingSpot.parkingSpotId === updatedParkingSpot.parkingSpotId
            ) {
              return updatedParkingSpot;
            } else {
              return parkingSpot;
            }
          }
        );
        this.filteredParkingSpots = [...this.filteredParkingSpots];
        this.sortEvent();
      } else {
        console.log('Dialog closed without data.');
      }
    });
    dialogRef.afterClosed().subscribe((parkingSpotId: String) => {
      if (parkingSpotId) {
        this.filteredParkingSpots = this.filteredParkingSpots.filter(
          (parkingSpot) => {
            return parkingSpot.parkingSpotId != parkingSpotId;
          }
        );
        this.filteredParkingSpots = [...this.filteredParkingSpots];
      } else {
        console.log('Dialog closed without data.');
      }
    });
  }
}
