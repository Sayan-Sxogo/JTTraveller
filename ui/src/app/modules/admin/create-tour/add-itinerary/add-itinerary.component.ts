import { Component, Input } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { CreateTour } from 'src/app/core/models/interfaces/tour';
import { TourService } from 'src/app/core/services/tour.service';
 
@Component({
  selector: 'app-add-itinerary',
  templateUrl: './add-itinerary.component.html',
  styleUrls: ['./add-itinerary.component.css'],
})
export class AddItineraryComponent {
  duration: number = 0; //formated durtaion
  idVal: any;
  defaultDayCount: number = 0;
  baseTour!: any; //formated baseTour
  showError: boolean = false;
  cards: number[] = [];
  iconState: string[] = [];
  private daysSubscription!: Subscription;
 
  constructor(
    public tourService: TourService,
    private activeRoute: ActivatedRoute,
    private router: Router
  ) {
    this.activeRoute.params.subscribe((res: any) => {
      this.idVal = res['id'];
    });
    this.daysSubscription = this.tourService.days$.subscribe((days) => {
      this.cards = Array.from({ length: days }, (_, i) => i + 1);
      this.iconState = Array.from({ length: days }, () => 'plus');
    });
  }
  ngOnInit() {
    this.tourService.baseTour.subscribe((data) => {
      this.baseTour = data;
      this.duration = this.baseTour.duration;
    });
  }

  Add_plans = new FormGroup({
    // dayCount: new FormControl(''), //? since dayCount is not being used anywhere, so I am commenting it
    place: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]),
    distanceToCover: new FormControl('', [Validators.required, Validators.min(1)]), //Validators.pattern('[0-9]*')
    activity: new FormControl('', [Validators.required, Validators.minLength(10), Validators.maxLength(100)]),
    name: new FormControl('', [Validators.required,  Validators.minLength(3), Validators.maxLength(30)]),
    address: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]),
    roomtype: new FormControl('', [Validators.required]),
  });

  accomodation: any = {};
  dayPlanData: any = {};
  dayPlans: any = [];
 
  itinerary: any = {};
  add() {
    // Accomodation Object
    this.accomodation['hotelName'] = this.Add_plans.value.name;
    this.accomodation['address'] = this.Add_plans.value.address;
    this.accomodation['roomType'] = this.Add_plans.value.roomtype;
    //Day Count Calculation using duration data feching from create tour form
    this.dayPlanData['dayCount'] = this.defaultDayCount;
 
    this.dayPlanData['place'] = this.Add_plans.value.place;
    this.dayPlanData['activity'] = this.Add_plans.value.activity;
    this.dayPlanData['distance'] = this.Add_plans.value.distanceToCover;
 
    this.dayPlanData['accomodation'] = { ...this.accomodation };
 
    // point to be noted here we have to push copy of object as object uses reference
    this.dayPlans.push({ ...this.dayPlanData });
    this.itinerary['dayPlans'] = this.dayPlans;
 
    const currentIndex = this.iconState.indexOf('plus');
    if (currentIndex >= 0) {
      this.iconState[currentIndex] = 'done';
      this.tourService.setIconState(this.iconState[currentIndex]);
    }
    this.Add_plans.reset();
  }
  finalData() {
    this.baseTour['itinerary'] = this.itinerary;
    console.log(this.baseTour);
    this.tourService.addTourData(this.baseTour).subscribe((res) => {
      console.log("res of final submit",res);
      return res;
    },(error)=>{
      console.log("error is  == ",error)
    });
    this.router.navigate(['']);
  }
  changeDayCardStatus() {
    if (this.Add_plans.invalid) {
      this.showError = true;
    }
    if (this.Add_plans.valid) {
      // this.tourService.dayCardStatus.next(true);
      this.defaultDayCount = this.defaultDayCount + 1;
    }
  }
  get daycount() {
    return this.Add_plans.get('daycount');
  }
  get place() {
    return this.Add_plans.get('place');
  }
  get activity() {
    return this.Add_plans.get('activity');
  }
  get distanceToCover() {
    return this.Add_plans.get('distanceToCover');
  }
  get name() {
    return this.Add_plans.get('name');
  }
  get address() {
    return this.Add_plans.get('address');
  }
  get roomtype() {
    return this.Add_plans.get('roomtype');
  }

 
  ngOnDestroy() {
    this.daysSubscription.unsubscribe();
  }
}