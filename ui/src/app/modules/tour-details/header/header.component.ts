import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  @Input() name:any;
  @Input() mode:any;
  @Input() difficultyLevel:any;
  @Input() days:any;
  @Input() nights:any;
  modeItem: string = '';
  modeGifs = {
    WALK: 'assets/gifs/walk.gif',
    MOTORBIKE: 'assets/gifs/bike.gif',
    BICYCLE: 'assets/gifs/cycle.gif',
  };
  style = {
    fill: '',
    textColor: '',
    bgColor: '',
  };
  ngOnInit(){
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
}
