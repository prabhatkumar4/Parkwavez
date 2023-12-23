import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParkitSpotListComponent } from './parkit-spot-list.component';

describe('ParkitSpotListComponent', () => {
  let component: ParkitSpotListComponent;
  let fixture: ComponentFixture<ParkitSpotListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParkitSpotListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParkitSpotListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
