import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewListFormComponent } from './review-list-form.component';

describe('ReviewListFormComponent', () => {
  let component: ReviewListFormComponent;
  let fixture: ComponentFixture<ReviewListFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReviewListFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReviewListFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
