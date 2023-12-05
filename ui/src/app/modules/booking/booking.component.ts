import { Component, effect, inject, signal, Signal } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BookingService } from 'src/app/core/services/booking.service';
 
@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css'],
})
export class BookingComponent {
  allowPayment: boolean = false;
  booking!: FormGroup;
  data!: any;
  bookingService = inject(BookingService);
  router = inject(Router);
  batchData: any;
  participants: any[] = [];
  seats = signal(0);
 
  bookingDataToPost:any = {}
 
  constructor() {
    this.booking = new FormGroup({
      name: new FormGroup({
        first: new FormControl('', [Validators.required]),
        last: new FormControl('', [Validators.required]),
      }),
      mobile: new FormGroup({
        number: new FormControl('', [Validators.required, Validators.pattern('[0-9]{10}')]),
      }),
    });
    effect(() => {
      this.batchData = this.bookingService.batchData();
      console.log(this.bookingService.batchData());
    });
    console.log(this.data);
  }
  ngOnInit() {
    this.seats.set(this.batchData.seats);
  }
  onSubmit() {
    this.allowPayment = true;
    this.seats.update((prev) => prev - 1);
    this.participants.push(this.booking.value);
    this.booking.reset();
    
  }
  onProceedToPayment() {
    this.bookingService.updateParticipantData(this.participants)
    this.router.navigateByUrl('/booking/payment');
  }


  get first() {
    return this.booking.get('name')?.get('first');
  }
}