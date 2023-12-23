import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ProviderDetails, Role } from '../../model/ProviderDetails';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserDetailsService } from '../../service/user-details.service';
import { ProfileImageComponent } from '../../components/profile-image/profile-image.component';
import { MatDialog } from '@angular/material/dialog';
import { Subscription } from 'rxjs';
import { AuthenticationService } from 'src/app/authentication.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  editing = false;
  providerId = 'ohndoe311235';
  providerForm!: FormGroup;
  provider!: ProviderDetails;
  dataSubscription!: Subscription;
  constructor(
    private authService: AuthenticationService,
    private location: Location,
    private fb: FormBuilder,
    private providerService: UserDetailsService,
    private dialog: MatDialog
  ) {
    this.createForm();
  }
  createForm() {
    this.providerForm = this.fb.group({
      userId: [this.provider?.userId || '', Validators.required],
      phone: ['', Validators.required],
      userName: [this.provider?.userName || '', Validators.required],
      email: [
        this.provider?.email || '',
        [Validators.required, Validators.email],
      ],
      role: [this.provider?.role || 'PROVIDER', Validators.required],
      address: this.fb.group({
        street: [this.provider?.address?.street || '', Validators.required],
        city: [this.provider?.address?.city || '', Validators.required],
        zip: [
          this.provider?.address?.zip || '',
          [Validators.required, Validators.pattern(/^\d+$/)],
        ],
        state: [this.provider?.address?.state || '', Validators.required],
      }),
    });
  }

  ngOnInit(): void {
    this.dataSubscription = this.authService.user.subscribe((user) => {
      this.providerId = user.username;
      this.getProvider();
    });
  }

  goBack(): void {
    this.location.back();
  }

  editToggle() {
    if (!this.editing) {
      this.createForm();
    }
    this.editing = !this.editing;
  }
  getProvider() {
    this.providerService.getUserDetails(this.providerId).subscribe(
      (user: ProviderDetails) => {
        user.image = 'data:image/png;base64,' + user.image;
        this.provider = user;
      },
      (err: any) => {
        console.log(err.message);
      }
    );
  }
  save() {
    this.providerService.updateUserDetails(this.providerForm.value).subscribe(
      (user: ProviderDetails) => {
        user.image = 'data:image/png;base64,' + user.image;
        this.provider = user;
        this.editToggle();
      },
      (err: any) => {
        console.log(err.message);
      }
    );
  }

  openAddDialog(): void {
    const dialogRef = this.dialog.open(ProfileImageComponent, {
      data: { provider: this.provider },
      enterAnimationDuration: '200ms',
      exitAnimationDuration: '200ms',
    });

    dialogRef.afterClosed().subscribe((profile: any) => {
      if (profile) {
        profile.image = 'data:image/png;base64,' + profile.image;
        this.provider = profile;
      } else {
        console.log('Dialog closed without data.');
      }
    });
  }
}
