import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_GATEWAY } from '../api';

@Injectable({
  providedIn: 'root',
})
export class RegistrationService {
  private backendUrl = `${API_GATEWAY}/auth/register`;

  constructor(private http: HttpClient) {}

  registerUser(registrationData: any): Observable<any> {
    return this.http.post(this.backendUrl, registrationData);
  }
}