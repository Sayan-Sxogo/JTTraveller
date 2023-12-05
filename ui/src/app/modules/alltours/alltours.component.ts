import { Component } from '@angular/core';
import { TourService } from 'src/app/core/services/tour.service';

@Component({
  selector: 'app-alltours',
  templateUrl: './alltours.component.html',
  styleUrls: ['./alltours.component.css']
})
export class AlltoursComponent {
  tours: any = [];
  constructor(private tourService: TourService) {}
  ngOnInit() {
    this.tourService.getTours().subscribe((res) => {
      console.log(res);
      this.tours = res;
      console.log(this.tours);
    });
    console.log('tour');
  }
}
