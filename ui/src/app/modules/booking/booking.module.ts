import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
// import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BookingComponent } from './booking.component';
import { RouterModule, Routes } from '@angular/router';
import { PaymentComponent } from './payment/payment.component';
import { ReactiveFormsModule } from '@angular/forms';

const routes: Routes = [
  { path: '', component: BookingComponent },
  { path: 'payment', component: PaymentComponent },
];
@NgModule({
  declarations: [BookingComponent, PaymentComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    ReactiveFormsModule,

  ],
})
export class BookingModule {}
