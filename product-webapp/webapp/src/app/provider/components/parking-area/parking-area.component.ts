import { Component, Input, OnInit, EventEmitter, Output } from '@angular/core';
import { ParkingArea } from '../../model/ParkingArea';
import { Router } from '@angular/router';
import { DataService } from '../../service/data-service.service';

@Component({
  selector: 'app-parking-area',
  templateUrl: './parking-area.component.html',
  styleUrls: ['./parking-area.component.css'],
})
export class ParkingAreaComponent implements OnInit {
  constructor(private _router: Router, private dataService: DataService) {}
  @Input() parkingArea!: ParkingArea;
  @Output() deleteParkingArea = new EventEmitter();
  ngOnInit(): void {}
  onDelete(areaId: any) {
    this.deleteParkingArea.emit(areaId);
  }
  onNavigate(parkingArea: ParkingArea) {
    this.dataService.parkingArea = parkingArea;
    this._router.navigate(['provider', 'area', parkingArea.areaId]);
  }
}
