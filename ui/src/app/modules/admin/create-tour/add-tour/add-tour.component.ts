import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';


import { CreateTour } from 'src/app/core/models/interfaces/tour';
import { TourService } from 'src/app/core/services/tour.service';

@Component({
  selector: 'app-add-tour',
  templateUrl: './add-tour.component.html',
  styleUrls: ['./add-tour.component.css'],
})
export class AddTourComponent {
  Add_Tour: FormGroup;
  showError: boolean = false;
  baseTour!: CreateTour;
  
  constructor(
    private router: Router,
    private tourService: TourService,
  ) {
    this.Add_Tour = new FormGroup({
      name: new FormControl('', [Validators.required]),
      startAt: new FormControl('', [Validators.required]),
      endAt: new FormControl('', [Validators.required]),
      mode: new FormControl('', [Validators.required]),
      difficultyLevel: new FormControl('', [Validators.required]),
    });
  }

  add() {
    if (this.Add_Tour.valid) {
      this.baseTour = this.Add_Tour.value
      this.tourService.baseTour.next(this.baseTour)
      this.tourService.setDays(this.Add_Tour.value.duration) //passing durtaion into services
      this.router.navigate(['/admin/add-itinerary'])
    }
  }
}
