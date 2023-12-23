import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ParkingArea } from '../model/ParkingArea';
import { API_GATEWAY } from 'src/app/api';

@Injectable({
  providedIn: 'root',
})
export class ParkingAreaService {
  API_URL = `${API_GATEWAY}/parking-area`;

  constructor(private _httpClient: HttpClient) {}
  addParkingSpace(
    providerId: string,
    parkingArea: ParkingArea
  ): Observable<ParkingArea> {
    return this._httpClient.post<ParkingArea>(
      `${this.API_URL}/provider/${providerId}/add`,
      parkingArea
    );
  }
  getParkingSpace(providerId: string): Observable<any[]> {
    return this._httpClient.get<any[]>(
      `${this.API_URL}/provider/${providerId}/get`
    );
  }
  deleteParkingSpace(areaId: string) {
    return this._httpClient.delete(`${this.API_URL}/provider/${areaId}/delete`);
  }
  updateParkingSpace(parkingArea: ParkingArea): Observable<ParkingArea> {
    return this._httpClient.put<ParkingArea>(
      `${this.API_URL}/provider/update`,
      parkingArea
    );
  }
  getParkingAreaById(areaId: string): Observable<ParkingArea> {
    return this._httpClient.get<ParkingArea>(
      `${this.API_URL}/public/get/${areaId}`
    );
  }
}
