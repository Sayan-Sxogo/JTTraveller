import { Component, inject } from '@angular/core';
import { StatsService } from 'src/app/core/services/stats.service';
import { TourService } from 'src/app/core/services/tour.service';

@Component({
  selector: 'app-jt-stats',
  templateUrl: './jt-stats.component.html',
  styleUrls: ['./jt-stats.component.css']
})
export class JtStatsComponent {
  tour = inject(TourService) 
  size:number = 0
  constructor(){
    this.tour.getTours().subscribe(res=>{
      let result:any = res
      this.size = result.length
    })
  }
}
