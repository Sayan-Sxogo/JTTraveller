import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JtStatsComponent } from './jt-stats.component';

describe('JtStatsComponent', () => {
  let component: JtStatsComponent;
  let fixture: ComponentFixture<JtStatsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [JtStatsComponent]
    });
    fixture = TestBed.createComponent(JtStatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
