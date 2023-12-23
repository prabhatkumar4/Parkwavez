import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProviderDetails } from '../model/ProviderDetails';
import { Observable } from 'rxjs';
import { API_GATEWAY } from 'src/app/api';

@Injectable({
  providedIn: 'root',
})
export class UserDetailsService {
  API_URL = `${API_GATEWAY}/provider-details`;
  constructor(private httpCient: HttpClient) {}
  getUserDetails(id: string): Observable<ProviderDetails> {
    return this.httpCient.get<ProviderDetails>(
      this.API_URL + '/' + id + '/get'
    );
  }
  updateUserDetails(
    providerDetails: ProviderDetails
  ): Observable<ProviderDetails> {
    return this.httpCient.put<ProviderDetails>(
      this.API_URL + '/update',
      providerDetails
    );
  }
  updateUserProfile(
    providerId: string,
    file: any
  ): Observable<ProviderDetails> {
    return this.httpCient.put<ProviderDetails>(
      this.API_URL + '/' + providerId + '/profile-picture',
      file
    );
  }
}
