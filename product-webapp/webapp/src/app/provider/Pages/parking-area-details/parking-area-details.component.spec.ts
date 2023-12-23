import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParkingAreaDetailsComponent } from './parking-area-details.component';

describe('ParkingAreaDetailsComponent', () => {
  let component: ParkingAreaDetailsComponent;
  let fixture: ComponentFixture<ParkingAreaDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParkingAreaDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParkingAreaDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
