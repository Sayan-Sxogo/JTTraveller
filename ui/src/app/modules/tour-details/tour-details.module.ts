import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TourDetailsComponent } from './tour-details.component';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { BatchesComponent } from './batches/batches.component';
import { DayPlansComponent } from './day-plans/day-plans.component';
import { CardComponent } from './card/card.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { FilterBatchesComponent } from './filter-batches/filter-batches.component';
import { FormsModule } from '@angular/forms';
const routes: Routes = [
  { path: 'details/:id', component: TourDetailsComponent },
];

@NgModule({
  declarations: [
    TourDetailsComponent,
    HeaderComponent,
    BatchesComponent,
    DayPlansComponent,
    CardComponent,
    FilterBatchesComponent,
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    SharedModule,
    CarouselModule,
    FormsModule
  ],
})
export class TourDetailsModule {}
