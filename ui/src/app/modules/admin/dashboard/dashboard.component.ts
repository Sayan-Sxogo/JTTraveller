import { Component, OnInit } from '@angular/core';
import { Tour } from 'src/app/core/models/interfaces/tour';
import { TourService } from 'src/app/core/services/tour.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  tours: Tour[] = [];

  constructor(private tour: TourService) {}

  ngOnInit(): void {
    this.tour.getTours().subscribe((data: any) => {
      console.log('services called...');
      console.log(data);
      this.tours = data;
    });
  }
}
