import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OwlOptions } from 'ngx-owl-carousel-o';
import { TourDetailsService } from 'src/app/core/services/tour-details.service';
import { TourService } from 'src/app/core/services/tour.service';
@Component({
  selector: 'app-batches',
  templateUrl: './batches.component.html',
  styleUrls: ['./batches.component.css'],
})
export class BatchesComponent {
  tours: any = [];
  activatedRoutes = inject(ActivatedRoute)
  id:any
  constructor(private tourService: TourDetailsService) {}
  ngOnInit() {
    this.activatedRoutes.paramMap.subscribe((params)=>{
      this.id = params.get('id')
    })
    this.tourService.getAllTourBatches(this.id).subscribe((res) => {
      this.tours = res;
    });
  }
  customOptions: OwlOptions = {
    loop: true,
    mouseDrag: false,
    touchDrag: false,
    pullDrag: false,
    dots: true,
    navSpeed: 600,
    navText: ['&#8249', '&#8250;'],
    responsive: {
      0: {
        items: 1,
      },
      400: {
        items: 2,
      },
      760: {
        items: 3,
      },
      1000: {
        items: 3,
      },
    },
    nav: true,
  };
}
