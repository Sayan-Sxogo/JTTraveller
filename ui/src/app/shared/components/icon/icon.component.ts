import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-icon',
  templateUrl: './icon.component.html',
  styleUrls: ['./icon.component.css']
})
export class IconComponent {
  @Input() icons ?:string
  
  constructor(){
    console.log("icon component");
    // console.log(this.icons);
  }
}
