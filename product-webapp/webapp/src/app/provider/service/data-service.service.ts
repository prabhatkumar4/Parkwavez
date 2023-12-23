import { Injectable } from '@angular/core';
import { ParkingArea } from '../model/ParkingArea';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  constructor() {}
  parkingArea!: ParkingArea;
}
