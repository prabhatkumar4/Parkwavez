import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPriceFornComponent } from './add-price-forn.component';

describe('AddPriceFornComponent', () => {
  let component: AddPriceFornComponent;
  let fixture: ComponentFixture<AddPriceFornComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPriceFornComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddPriceFornComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
