import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { API_GATEWAY } from './api';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  private baseUrl = API_GATEWAY;

  private userSubject = new BehaviorSubject<any | null>(null);
  user: Observable<any | null> = this.userSubject.asObservable();

  constructor(private http: HttpClient) {
    const user = localStorage.getItem('user');
    if (user) {
      this.userSubject.next(JSON.parse(user));
    }
  }

  login(username: string, password: string): Observable<any> {
    const body = { username, password };
    return this.http.post(`${this.baseUrl}/auth/login`, body);
  }

  getHttpHeaders(): HttpHeaders {
    const headers = new HttpHeaders({
      Authorization: `Bearer ${this.getToken()}`,
      'Content-Type': 'application/json',
    });
    return headers;
  }

  isAuthenticated(): boolean {
    const token = this.getToken();
    return !!token;
  }

  getUserData(): Observable<any> {
    const headers = this.getHttpHeaders();
    return this.http.get(`${this.baseUrl}/user/`, { headers });
  }

  getAdminData(): Observable<any> {
    const headers = this.getHttpHeaders();
    return this.http.get(`${this.baseUrl}/admin/`, { headers });
  }
  setToken(token: string) {
    localStorage.setItem('token', JSON.stringify(token));
  }

  getToken(): string | null {
    const token = localStorage.getItem('token');
    if (!token) {
      return null;
    }
    return JSON.parse(token);
  }

  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    this.userSubject.next(null);
  }
  setUser(user: any) {
    if (user != null) {
      localStorage.setItem('user', JSON.stringify(user));
      this.userSubject.next(user);
    }
  }
  getUser() {
    const user = localStorage.getItem('user');
    if (user != null) {
      return JSON.parse(user);
    } else {
      return null;
    }
  }
}
