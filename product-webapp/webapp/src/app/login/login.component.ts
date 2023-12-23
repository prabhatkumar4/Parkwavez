import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  username = '';
  password = '';

  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}

  onSubmit() {
    console.log('Form submitted');
    this.authService.login(this.username, this.password).subscribe(
      (response) => {
        console.log(response);
        if (response.user.authorities[0].authority === 'CUSTOMER') {
          // User authority, navigate to user page
          this.authService.setToken(response.jwt);
          this.authService.setUser(response.user);
          this.router.navigate(['/customer']);
        } else if (response.user.authorities[0].authority === 'PROVIDER') {
          this.authService.setToken(response.jwt);
          this.authService.setUser(response.user);
          this.router.navigate(['/provider']);
        }
      },
      (error) => {
        console.error('Login error:', error);
      }
    );
  }

  navigateToRegistration() {
    this.router.navigate(['/register']);
  }
  navigateToResetPassword() {
    this.router.navigate(['/reset-password']);
  }
}
