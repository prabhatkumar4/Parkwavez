import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Price } from '../model/PriceModel';
import { API_GATEWAY } from 'src/app/api';

@Injectable({
  providedIn: 'root',
})
export class PriceService {
  API_URL = `${API_GATEWAY}/price-service`;
  constructor(private _httpClient: HttpClient) {}
  public getPrice(areaId: string): Observable<Price[]> {
    return this._httpClient.get<Price[]>(
      `${this.API_URL}/public/get-price/${areaId}`
    );
  }
  public addPrice(price: Price): Observable<Price> {
    return this._httpClient.post<Price>(`${this.API_URL}/provider/add`, price);
  }
  public updatePrice(price: Price): Observable<Price> {
    return this._httpClient.put<Price>(
      `${this.API_URL}/provider/update`,
      price
    );
  }
}
