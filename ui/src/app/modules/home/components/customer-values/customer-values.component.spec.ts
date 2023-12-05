import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerValuesComponent } from './customer-values.component';

describe('CustomerValuesComponent', () => {
  let component: CustomerValuesComponent;
  let fixture: ComponentFixture<CustomerValuesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CustomerValuesComponent]
    });
    fixture = TestBed.createComponent(CustomerValuesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
