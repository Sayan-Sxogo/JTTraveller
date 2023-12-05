import { Component } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { TourService } from 'src/app/core/services/tour.service';

@Component({
  selector: 'app-tour-details',
  templateUrl: './tour-details.component.html',
  styleUrls: ['./tour-details.component.css'],
})
export class TourDetailsComponent {
  id: any;
  tourData:any
  constructor(private activatedRoute: ActivatedRoute, private router: Router, private tourService:TourService) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) window.scrollTo(0, 0);
    });
  }
  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((params) => {
      this.id = params.get('id');
      console.log(this.id);
    });
    this.tourService.getTourById(this.id).subscribe((data)=>{
      this.tourData = data
      console.log(data);
    })
  }
}
