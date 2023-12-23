import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_GATEWAY } from '../api';

@Injectable({
  providedIn: 'root',
})
export class ResetPasswordService {
  private resetPasswordUrl = `${API_GATEWAY}/auth/reset-password`;

  constructor(private http: HttpClient) {}

  resetPassword(username: string, newPassword: string): Observable<string> {
    const resetPasswordRequest = {
      username: username,
      newPassword: newPassword,
    };

    return this.http.post(this.resetPasswordUrl, resetPasswordRequest, {
      responseType: 'text',
    });
  }
}
