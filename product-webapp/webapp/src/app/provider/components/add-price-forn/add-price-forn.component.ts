import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { SpotType, ChargeType, Price } from '../../model/PriceModel';
import { PriceService } from '../../service/price.service';
import { FormBuilder, FormGroup } from '@angular/forms';
@Component({
  selector: 'app-add-price-forn',
  templateUrl: './add-price-forn.component.html',
  styleUrls: ['./add-price-forn.component.css'],
})
export class AddPriceFornComponent implements OnInit {
  spotTypes = ['TwoWheeler', 'FourWheeler', 'BigVehicle', 'Handicap'];
  chargeTypes = ['Hourly', 'Monthly', 'Residental', 'Yearly'];
  priceForm!: FormGroup;
  constructor(
    private priceService: PriceService,
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<AddPriceFornComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}
  ngOnInit(): void {
    this.priceForm = this.fb.group({
      areaId: [this.data.areaId],
      spotType: [''],
      chargeType: [''],
      price: [''],
      discount: [''],
    });
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
  onAdd() {
    this.priceService.addPrice(this.priceForm.value).subscribe((price:Price) => {
      this.dialogRef.close(price);
    });
  }
}
