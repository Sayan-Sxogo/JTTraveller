import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewBatchesComponent } from './view-batches.component';

describe('ViewBatchesComponent', () => {
  let component: ViewBatchesComponent;
  let fixture: ComponentFixture<ViewBatchesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewBatchesComponent]
    });
    fixture = TestBed.createComponent(ViewBatchesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
