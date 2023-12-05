import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlltoursComponent } from './alltours.component';

describe('AlltoursComponent', () => {
  let component: AlltoursComponent;
  let fixture: ComponentFixture<AlltoursComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AlltoursComponent]
    });
    fixture = TestBed.createComponent(AlltoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
