import { Component, effect, inject } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { BookingService } from 'src/app/core/services/booking.service';
 
@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css'],
})
export class PaymentComponent {
  card: boolean = true;
  tosterService = inject(ToastrService);
  bookingService = inject(BookingService)
  batchData: any;
  participantList!:any[]
  bookingJson:any = {}

  constructor(private router: Router){
    effect(()=>{
      this.batchData = this.bookingService.batchData()
      this.participantList = this.bookingService.participantList()
      console.log(this.batchData)
      console.log(this.participantList)
    })
  }
  
  pay() {
    // {batchId: 1, startDate: '2023-11-25', seats: 10, costs: 5000}
    const currentDate = new Date();
    const year = currentDate.getFullYear();
    const month = String(currentDate.getMonth() + 1).padStart(2, '0');
    const day = String(currentDate.getDate()).padStart(2, '0');
    const date = `${year}-${month}-${day}`;

    console.log(sessionStorage.getItem('userName'))
    console.log(date)

    this.bookingJson["date"] = date;
    this.bookingJson["username"] = sessionStorage.getItem('userName')
    this.bookingJson["batchId"] = this.batchData.batchId
    this.bookingJson["amount"] = this.participantList.length * this.batchData.costs
    this.bookingJson['travellers'] = this.participantList
    this.tosterService.success('Hurrayyy', 'Booked', {
      timeOut: 2000,
    });
    console.log(this.bookingJson)
    console.log('paid');
   
    this.bookingService.bookingDataPost(this.bookingJson).subscribe(res=>{
      // console.log(res)
      this.router.navigateByUrl('/')
    })
  }

  useCard() {
    if (!this.card) this.card = true;
    // console.log("card")
  }
  useUPI() {
    if (this.card) this.card = false;
    // console.log("upi")
  }
}