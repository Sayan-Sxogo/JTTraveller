import { Component } from '@angular/core';
import { BookingService } from '../../../core/services/booking.service'

@Component({
  selector: 'app-all-bookings',
  templateUrl: './all-bookings.component.html',
  styleUrls: ['./all-bookings.component.css']
})
export class AllBookingsComponent {
  traveller = 0
  allBookings:any[] = [];
  constructor(private bookingService: BookingService) {
    this.bookingService.getAllBookings().subscribe((data) => {
      this.allBookings = data;
      console.log(this.allBookings)
    })
  }

}


// {
//   "id": 1,
//   "date": "2023-11-25",
//   "amount": 4600,
//   "batchId": 1,
//   "username": "amar.pradhan@fakmail.com",
//   "travellers": [
//       {
//           "sequence": 3,
//           "mobile": {
//               "number": "8384484834"
//           },
//           "name": {
//               "first": "Swarnali",
//               "last": "Saha"
//           }
//       },
//       {
//           "sequence": 4,
//           "mobile": {
//               "number": "9284938989"
//           },
//           "name": {
//               "first": "Arunava",
//               "last": "Das"
//           }
//       }
//   ]
// }