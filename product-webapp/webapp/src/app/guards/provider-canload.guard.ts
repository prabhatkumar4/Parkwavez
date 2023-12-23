import { Injectable } from '@angular/core';
import { CanLoad, Route, UrlSegment, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../authentication.service';

@Injectable({
  providedIn: 'root',
})
export class ProviderCanload implements CanLoad {
  constructor(private authService: AuthenticationService) {}

  checkTokenExpiration() {
    const user = this.authService.getUser();
    return user == null ? false : true;
  }

  canLoad() {
    return this.checkTokenExpiration();
  }
}
