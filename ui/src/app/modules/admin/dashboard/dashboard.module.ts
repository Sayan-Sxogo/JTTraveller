import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { AdminStatsComponent } from './admin-stats/admin-stats.component';
import { StatCardComponent } from './admin-stats/stat-card/stat-card.component';
import { DashboardMenuComponent } from './dashboard-menu/dashboard-menu.component';
import { ToursListComponent } from './tours-list/tours-list.component';
import { BadgeComponent } from './tours-list/badge/badge.component';
// import { IconComponent } from 'src/app/shared/components/icon/icon.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { BookingComponent } from './booking/booking.component';



@NgModule({
  declarations: [
    DashboardComponent,
    AdminProfileComponent,
    AdminStatsComponent,
    StatCardComponent,
    DashboardMenuComponent,
    ToursListComponent,
    BadgeComponent,
    BookingComponent,
    // IconComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ]
})
export class DashboardModule { }
