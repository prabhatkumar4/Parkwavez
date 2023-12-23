import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RegistrationService } from './registration.service';
import { Router } from '@angular/router'; // Import the Router

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  registrationForm!: FormGroup;
  registrationSuccess = false; // Add a flag to track registration success

  constructor(
    private fb: FormBuilder,
    private registrationService: RegistrationService,
    private router: Router // Inject the Router
  ) {}


  ngOnInit() {
    this.registrationForm = this.fb.group({
      username: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      emailId: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      role: ['', Validators.required],
      agreeTerms: [false, Validators.requiredTrue],
    });
  }
  onSubmit() {
    if (this.registrationForm.valid) {
      // Get the form values and send them to the service
      const registrationData = this.registrationForm.value;
      this.registrationService.registerUser(registrationData).subscribe(
        (response) => {
          console.log('Registration successful', response);
          this.registrationSuccess = true;
        
          setTimeout(() => {
            this.navigateToLogin();
          }, 2000);
        },
        
        (error) => {
          console.error('Registration failed', error);
         
        }
      );
    }
  }

 
  navigateToLogin() {
    this.router.navigate(['/login']);
  }
}