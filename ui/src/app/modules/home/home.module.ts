import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { HeroComponent } from './components/hero/hero.component';
import { ListToursComponent } from './components/list-tours/list-tours.component';
import { JtStatsComponent } from './components/jt-stats/jt-stats.component';
import { CustomerValuesComponent } from './components/customer-values/customer-values.component';
import { SlickCarouselModule } from 'ngx-slick-carousel';
import { CardComponent } from './components/card/card.component';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [
    HomeComponent,
    HeroComponent,
    ListToursComponent,
    JtStatsComponent,
    CustomerValuesComponent,
    CardComponent
  ],
  exports:[HomeComponent],
  imports: [
    CommonModule,
    SlickCarouselModule,
    CarouselModule,
    SharedModule
  ]
})
export class HomeModule { }
