import { Component } from '@angular/core';
import { BatchService } from 'src/app/core/services/batch.service';
import { BookingService } from 'src/app/core/services/booking.service';
import { GreetingService } from 'src/app/core/services/greeting.service';
import { TourService } from 'src/app/core/services/tour.service';

@Component({
  selector: 'app-admin-stats',
  templateUrl: './admin-stats.component.html',
  styleUrls: ['./admin-stats.component.css'],
})
export class AdminStatsComponent {
  enrolled = 0;
  batches = 0;
  tours = 0;
  revenue = 0;
  quote!: any;
  greeting!: string;
  adminName: string | undefined;

  constructor(private greetingService: GreetingService, private bookingService: BookingService, private batchService: BatchService, private tourService:TourService) {
    this.adminName = sessionStorage.getItem('userName')?.split('@')[0];


  }
  ngOnInit() {
    const date = new Date();
    let hours = date.getHours();
    this.greeting =
      hours < 12
        ? 'Morning'
        : hours <= 18 && hours >= 12
        ? 'Afternoon'
        : 'Night';
    this.greetingService.getRandomQuote().subscribe((res) => {
      this.quote = res;
      console.log(this.quote);
    });


    // 1 & 4
    this.bookingService.getAllBookings().subscribe((data) => {
      let result:any = data;
      let travellers = 0;
      result.forEach((element: { travellers: string | any[]; }) => {
        travellers = element.travellers.length + travellers
      });
      this.enrolled = travellers;

      result.forEach((element:any) => {
        this.revenue = element.amount + this.revenue
      });
    })

    // 2
    this.batchService.getBatchesAdmin().subscribe((data:any) => {
      this.batches = data.length
    })
 
    // 3
    this.tourService.getTours().subscribe((data:any) => {
      this.tours = data.length
    })
  }
}
