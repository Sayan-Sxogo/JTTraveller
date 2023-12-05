import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItineraryCardsComponent } from './itinerary-cards.component';

describe('ItineraryCardsComponent', () => {
  let component: ItineraryCardsComponent;
  let fixture: ComponentFixture<ItineraryCardsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ItineraryCardsComponent]
    });
    fixture = TestBed.createComponent(ItineraryCardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
