import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import { DashboardModule } from './dashboard/dashboard.module';
import { ViewBatchesModule } from './view-batches/view-batches.module';
import { CreateBatchModule } from './create-batch/create-batch.module';
import { CreateTourModule } from './create-tour/create-tour.module';
import { TourService } from 'src/app/core/services/tour.service';
import { AllBookingsComponent } from './all-bookings/all-bookings.component';

@NgModule({
  declarations: [
    AllBookingsComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    DashboardModule,
    ViewBatchesModule,
    CreateBatchModule,
    CreateTourModule
  ],
  providers:[TourService]
})
export class AdminModule {}
