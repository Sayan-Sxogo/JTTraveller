import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ViewBatchesComponent } from './view-batches/view-batches.component';
import { CreateBatchComponent } from './create-batch/create-batch.component';
import { AddTourComponent } from './create-tour/add-tour/add-tour.component';
import { AddItineraryComponent } from './create-tour/add-itinerary/add-itinerary.component';
import { authGuard } from 'src/app/core/guard/auth.guard';
import { BookingComponent } from './dashboard/booking/booking.component';
import { AllBookingsComponent } from './all-bookings/all-bookings.component';

const routes: Routes = [
  {
    path: 'dashboard',
    component: DashboardComponent,
    // canActivate: [authGuard],
  },
  { path: 'view-batches/:id', component: ViewBatchesComponent },
  // { path: 'create-batch', component: CreateBatchComponent },
  { path: 'add-tour', component: AddTourComponent },
  { path: 'add-itinerary', component: AddItineraryComponent },
  { path: 'bookings', component: AllBookingsComponent }
  // { path: 'booking', component: BookingComponent },
];

@NgModule({
  declarations: [],
  imports: [CommonModule, RouterModule.forChild(routes)],
})
export class AdminRoutingModule {
  constructor() {
    console.log('admin routing class called');
  }
}
