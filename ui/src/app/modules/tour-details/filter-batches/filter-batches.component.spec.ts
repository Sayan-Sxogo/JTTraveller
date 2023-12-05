import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FilterBatchesComponent } from './filter-batches.component';

describe('FilterBatchesComponent', () => {
  let component: FilterBatchesComponent;
  let fixture: ComponentFixture<FilterBatchesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FilterBatchesComponent]
    });
    fixture = TestBed.createComponent(FilterBatchesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
