import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccantSpaceComponent } from './vaccant-space.component';

describe('VaccantSpaceComponent', () => {
  let component: VaccantSpaceComponent;
  let fixture: ComponentFixture<VaccantSpaceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VaccantSpaceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VaccantSpaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
