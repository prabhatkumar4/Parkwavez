import { TestBed } from '@angular/core/testing';

import { ParkingAreaNService } from './parking-area-n.service';

describe('ParkingAreaNService', () => {
  let service: ParkingAreaNService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ParkingAreaNService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
