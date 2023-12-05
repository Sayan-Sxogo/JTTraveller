import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-badge',
  templateUrl: './badge.component.html',
  styleUrls: ['./badge.component.css']
})
export class BadgeComponent {
  @Input() status: any;


  colorOptions = {
    'red': {
      'top': 'bg-red-100 text-red-700',
      'bottom': 'bg-red-600'
    },
    'green': {
      'top': 'bg-green-100 text-green-800',
      'bottom': 'bg-green-500'
    },
    'blue': {
      'top': 'bg-blue-100 text-blue-700',
      'bottom': 'bg-blue-600'
    },
    'yellow': {
      'top': 'bg-yellow-100 text-yellow-800',
      'bottom': 'bg-yellow-500'
    }
  }
}
