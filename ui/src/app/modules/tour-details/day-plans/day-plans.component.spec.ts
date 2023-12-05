import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DayPlansComponent } from './day-plans.component';

describe('DayPlansComponent', () => {
  let component: DayPlansComponent;
  let fixture: ComponentFixture<DayPlansComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DayPlansComponent]
    });
    fixture = TestBed.createComponent(DayPlansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
