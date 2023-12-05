import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {
  @Input() id?: any;
  @Input() src?: string;
  @Input() name?: string;
  @Input() difficultyLevel?: string;
  @Input() duration?: number;
  @Input() mode?: string;
  constructor(private router: Router) {}
  fill: string = '';
  modeItem: string = '';
  style = {
    fill: '',
    textColor: '',
    bgColor: '',
  };
  modeGifs = {
    WALK: 'assets/gifs/walk.gif',
    MOTORBIKE: 'assets/gifs/bike.gif',
    BICYCLE: 'assets/gifs/cycle.gif',
  };
  ngOnInit() {
    // console.log(this.difficultyLevel);
    if (this.difficultyLevel == 'EASY') {
      // this.fill = '#ffff00';
      this.style['fill'] = '#009900';
      this.style['textColor'] = '#009900';
      this.style['bgColor'] = '#80ff80';
    } else if (this.difficultyLevel == 'MODERATE') {
      this.style['fill'] = '#ffff00';
      this.style['textColor'] = '#cccc00';
      this.style['bgColor'] = '#ffffcc';
    } else if (this.difficultyLevel == 'CHALLENGING') {
      this.style['fill'] = '#cc0000';
      this.style['textColor'] = '#ff9999';
      this.style['bgColor'] = '#ffcccc';
    }

    if (this.mode == 'WALK') {
      this.modeItem = this.modeGifs.WALK;
    } else if (this.mode == 'MOTORBIKE') {
      this.modeItem = this.modeGifs.MOTORBIKE;
    } else if (this.mode == 'BICYCLE') {
      this.modeItem = this.modeGifs.BICYCLE;
    }
  }
  navigateToTourDetails() {
    this.router.navigate(['/tour/details/' + this.id ]);
  }
}
