import { Component, Input } from '@angular/core';
import { TourService } from 'src/app/core/services/tour.service';

@Component({
  selector: 'app-itinerary-cards',
  templateUrl: './itinerary-cards.component.html',
  styleUrls: ['./itinerary-cards.component.css'],
})
export class ItineraryCardsComponent {
  @Input() cardNumber!: number;
  @Input() duration!: any;
  @Input() icon!: string;
  doneStatus!: boolean;
  constructor(private tourService: TourService) {}

  ngOnInit() {
    this.tourService.dayCardStatus.subscribe((data) => {
      this.doneStatus = data;
    });
  }
}
