import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ResetPasswordService } from './reset-password.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent {
  passwordResetSuccessful = false; 
  passwordResetError = false; 

  constructor(
    private resetPasswordService: ResetPasswordService,
    private router: Router
  ) {}

  resetPassword(username: string, newPassword: string) {
    this.resetPasswordService.resetPassword(username, newPassword).subscribe(
      (response) => {
        if (response === 'Password reset successful') {
          console.log('Password reset successful');
          this.passwordResetSuccessful = true; 
          this.passwordResetError = false; 
          
         
          setTimeout(() => {
            this.router.navigate(['/login']);
          }, 2000);
        } else {
          console.error('Password reset failed');
          this.passwordResetError = true; // Set to true on failure
          // Handle failure (e.g., show an error message)
        }
      },
      (error) => {
        console.error('HTTP error:', error);
        this.passwordResetError = true; // Set to true on HTTP error
        // Handle HTTP error (e.g., show an error message)
      }
    );
  }
}
