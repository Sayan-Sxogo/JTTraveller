import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { AddItineraryComponent } from './add-itinerary/add-itinerary.component';
import { AddTourComponent } from './add-tour/add-tour.component';
import { ItineraryCardsComponent } from './itinerary-cards/itinerary-cards.component';


// import { AddItineraryComponent } from './add-itinerary/add-itinerary.component';
// import { CreateTourService } from './create-tour.service';
// import { AddTourComponent } from './add-tour/add-tour.component';

@NgModule({
  declarations: [AddItineraryComponent,AddTourComponent, ItineraryCardsComponent],
  imports: [CommonModule, ReactiveFormsModule],
})
export class CreateTourModule {}
