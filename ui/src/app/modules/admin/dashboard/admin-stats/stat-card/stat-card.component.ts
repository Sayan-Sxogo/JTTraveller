import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-stat-card',
  templateUrl: './stat-card.component.html',
  styleUrls: ['./stat-card.component.css']
})
export class StatCardComponent {
    constructor() {}

  @Input() title: string = "";
  @Input() statNumber: number = 0;
  @Input() icon: string = "";

  ngOnInit() {
    // console.log(this.title)
  }
}
