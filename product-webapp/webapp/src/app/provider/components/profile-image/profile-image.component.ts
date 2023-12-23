import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ProviderDetails } from '../../model/ProviderDetails';
import { UserDetailsService } from '../../service/user-details.service';

@Component({
  selector: 'app-profile-image',
  templateUrl: './profile-image.component.html',
  styleUrls: ['./profile-image.component.css'],
})
export class ProfileImageComponent {
  selectedFile!: File;
  constructor(
    private providerDetails: UserDetailsService,
    public dialogRef: MatDialogRef<ProfileImageComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { provider: ProviderDetails }
  ) {
    console.log(this.data.provider);
  }
  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
  }

  onSubmit(): void {
    if (this.selectedFile) {
       const formData = new FormData();
       formData.append('file', this.selectedFile);
      this.providerDetails
        .updateUserProfile(this.data.provider.userId, formData)
        .subscribe(
          (data: any) => {
            this.dialogRef.close(data);
          },
          (err: any) => {
            console.log(err);
          }
        );
    } else {
      console.error('No file selected.');
    }
  }
}
