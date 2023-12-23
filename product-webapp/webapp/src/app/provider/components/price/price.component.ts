import { Component, Input, OnInit, Inject } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Price } from '../../model/PriceModel';
import { PriceService } from '../../service/price.service';
import { MatDialog } from '@angular/material/dialog';
import { AddPriceFornComponent } from '../add-price-forn/add-price-forn.component';
import { FormBuilder, FormGroup } from '@angular/forms';
import { EditPriceFormComponent } from '../edit-price-form/edit-price-form.component';
@Component({
  selector: 'app-price',
  templateUrl: './price.component.html',
  styleUrls: ['./price.component.css'],
})
export class PriceComponent implements OnInit {
  @Input() areaId!: string;
  prices: Price[] = [];
  priceForm: FormGroup;
  displayedColumns: string[] = [
    'spotType',
    'chargeType',
    'price',
    'discount',
    'action',
  ];
  editedData!: Price;
  dataSource = new MatTableDataSource<Price>(this.prices);
  constructor(
    private priceService: PriceService,
    private dialog: MatDialog,
    private fb: FormBuilder
  ) {
    this.priceForm = this.fb.group({
      priceId: [''],
      areaId: [''],
      spotType: [''],
      chargeType: [''],
      price: [''],
      discount: [''],
    });
  }
  ngOnInit(): void {
    this.getPrice();
  }
  openAddDialog(): void {
    const dialogRef = this.dialog.open(AddPriceFornComponent, {
      data: { areaId: this.areaId },
      enterAnimationDuration: '200ms',
      exitAnimationDuration: '200ms',
    });

    dialogRef.afterClosed().subscribe((price: Price) => {
      if (price) {
        this.prices = [...this.prices, price];
      } else {
        console.log('Dialog closed without data.');
      }
    });
  }
  openEditDialog(price: Price): void {
    const dialogRef = this.dialog.open(EditPriceFormComponent, {
      data: { price },
      enterAnimationDuration: '200ms',
      exitAnimationDuration: '200ms',
    });

    dialogRef.afterClosed().subscribe((updatedPrice: Price) => {
      if (updatedPrice) {
        this.prices = this.prices.map((price) => {
          if (updatedPrice.priceId == price.priceId) {
            return updatedPrice;
          } else {
            return price;
          }
        });
      } else {
        console.log('Dialog closed without data.');
      }
    });
  }
  getPrice() {
    this.priceService.getPrice(this.areaId).subscribe((res: Price[]) => {
      this.prices = res;
      this.dataSource = new MatTableDataSource<Price>(this.prices);
    });
  }
}
