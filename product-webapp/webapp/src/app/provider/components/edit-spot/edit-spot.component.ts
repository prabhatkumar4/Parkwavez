import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ParkingSpotService } from '../../service/parking-spot.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ParkingSpot } from '../../model/ParkingSpot';

@Component({
  selector: 'app-edit-spot',
  templateUrl: './edit-spot.component.html',
  styleUrls: ['./edit-spot.component.css'],
})
export class EditSpotComponent {
  spotForm!: FormGroup;
  error!: string;
  spotTypes = ['TwoWheeler', 'FourWheeler', 'BigVehicle', 'Handicap'];
  constructor(
    private parkingSpotService: ParkingSpotService,
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<EditSpotComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { parkingSpot: ParkingSpot }
  ) {
    this.spotForm = this.fb.group({
      parkingSpotId: [this.data.parkingSpot.parkingSpotId],
      parkingSpotNumber: [this.data.parkingSpot.parkingSpotNumber],
      spotType: [this.data.parkingSpot.spotType],
      occupied: [this.data.parkingSpot.occupied],
      parkingAreaId: [this.data.parkingSpot.parkingAreaId],
    });
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
  onUpdate() {
    this.parkingSpotService.updateParkingSpot(this.spotForm.value).subscribe(
      (updatedSpot: ParkingSpot) => {
        this.dialogRef.close(updatedSpot);
      },
      (error) => {
        this.error = error.message;
      }
    );
  }
  onDelete() {
    this.parkingSpotService
      .deleteParkingSpot(this.data.parkingSpot.parkingSpotId)
      .subscribe(
        (result: any) => {
          this.dialogRef.close(this.data.parkingSpot.parkingSpotId);
        },
        (error) => {
          this.error = error.message;
        }
      );
  }
}
