import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddParkingAreaFormComponent } from './add-parking-area-form.component';

describe('AddParkingAreaFormComponent', () => {
  let component: AddParkingAreaFormComponent;
  let fixture: ComponentFixture<AddParkingAreaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddParkingAreaFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddParkingAreaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
