import { Component, Inject } from '@angular/core';
import { Price } from '../../model/PriceModel';
import { FormBuilder, FormGroup } from '@angular/forms';
import { PriceService } from '../../service/price.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-edit-price-form',
  templateUrl: './edit-price-form.component.html',
  styleUrls: ['./edit-price-form.component.css'],
})
export class EditPriceFormComponent {
  priceForm!: FormGroup;
  error!: string;
  constructor(
    private priceService: PriceService,
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<EditPriceFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { price: Price }
  ) {
    this.priceForm = this.fb.group({
      priceId: [this.data.price.priceId],
      areaId: [this.data.price.areaId],
      spotType: [this.data.price.spotType],
      chargeType: [this.data.price.chargeType],
      price: [this.data.price.price],
      discount: [this.data.price.discount],
    });
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
  onUpdate() {
    this.priceService.updatePrice(this.priceForm.value).subscribe(
      (price: Price) => {
        this.dialogRef.close(price);
      },
      (error) => {
        this.error = error.message;
      }
    );
  }
}
