import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-difficulty',
  templateUrl: './difficulty.component.html',
  styleUrls: ['./difficulty.component.css'],
})
export class DifficultyComponent {
  @Input() fillColor?: string;
  // fillColor?: string = 'fff';
}
