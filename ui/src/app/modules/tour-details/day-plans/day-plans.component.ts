import {
  animate,
  AnimationBuilder,
  keyframes,
  style,
} from '@angular/animations';
import { Component, ElementRef, HostListener, inject, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TourService } from 'src/app/core/services/tour.service';

@Component({
  selector: 'app-day-plans',
  templateUrl: './day-plans.component.html',
  styleUrls: ['./day-plans.component.css'],
})
export class DayPlansComponent {
  @ViewChild('itineraryCard') itineraryCard!: ElementRef;
  id:any //id from url
  // itinerary = [
  //   {
  //     dayCount: 1,
  //     place: 'Mumbau',
  //     activity: '',
  //     distance: 0.0,
  //     accomodation: {
  //       hotelName: 'Mayur',
  //       address: 'SB road',
  //       roomType: 'DOUBLE_BED',
  //     },
  //   },
  //   {
  //     dayCount: 2,
  //     place: 'NASIK',
  //     activity: '',
  //     distance: 150.0,
  //     accomodation: {
  //       hotelName: 'Dwaraka',
  //       address: 'Dwaraka',
  //       roomType: 'TWIN_BED',
  //     },
  //   },
  //   {
  //     dayCount: 3,
  //     place: 'NASIK',
  //     activity: '',
  //     distance: 0.0,
  //     accomodation: {
  //       hotelName: 'Dwaraka',
  //       address: 'Dwaraka',
  //       roomType: 'TWIN_BED',
  //     },
  //   },
  //   {
  //     dayCount: 4,
  //     place: 'NASIK',
  //     activity: '',
  //     distance: 0.0,
  //     accomodation: {
  //       hotelName: 'Dwaraka',
  //       address: 'Dwaraka',
  //       roomType: 'TWIN_BED',
  //     },
  //   },
  //   {
  //     dayCount: 5,
  //     place: 'NASIK',
  //     activity: '',
  //     distance: 0.0,
  //     accomodation: {
  //       hotelName: 'Dwaraka',
  //       address: 'Dwaraka',
  //       roomType: 'TWIN_BED',
  //     },
  //   },
  //   {
  //     dayCount: 6,
  //     place: 'NASIK',
  //     activity: '',
  //     distance: 0.0,
  //     accomodation: {
  //       hotelName: 'Dwaraka',
  //       address: 'Dwaraka',
  //       roomType: 'TWIN_BED',
  //     },
  //   },
  // ];
  tourData:any
  constructor(private animationBuilder: AnimationBuilder) {
    console.log(this.itineraryCard);
    console.log('itinerary cards constructor');
  }
  activatedRoutes = inject(ActivatedRoute)
  tourServices = inject(TourService)
  ngOnInit() {
    this.activatedRoutes.paramMap.subscribe((param)=>{
      this.id = param.get('id')
    })
    this.tourServices.getTourById(this.id).subscribe((res)=>{
      this.tourData = res
      console.log("res",res);
    })
  }
  @HostListener('window:load', ['$event'])
  onLoad(event: Event) {
    console.log(this.itineraryCard);
  }
  @ViewChild('cardsWrapper') cardsWrapper!: ElementRef;
  @ViewChild('cards') cards!: ElementRef;

  // ngAfterViewInit() {
  //   this.setupAnimations();
  // }

  setupAnimations() {
    const numCards = this.cards.nativeElement.children.length;

    this.cardsWrapper.nativeElement.style.setProperty('--numcards', numCards);

    // Simulating ViewTimeline
    const viewTimeline = {
      subject: this.cardsWrapper.nativeElement,
      axis: 'block',
    };

    this.cards.nativeElement.children.forEach(
      (card: HTMLElement, index0: number) => {
        const index = index0 + 1;
        const reverseIndex0 = numCards - index;

        // Scroll-Linked Animation
        const animation = this.animationBuilder.build([
          animate(
            '1s',
            keyframes([
              style({ transform: 'scale(1)', offset: 0 }),
              style({
                transform: `scale(${1 - 0.1 * reverseIndex0})`,
                offset: 1,
              }),
            ])
          ),
        ]);

        const player = animation.create(card);

        // Trigger the animation when in view
        viewTimeline.subject.addEventListener('scroll', () => {
          const rect = card.getBoundingClientRect();
          if (rect.top < window.innerHeight && rect.bottom >= 0) {
            player.play();
          }
        });
      }
    );
  }

  
}
