import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes } from '@angular/router';
import { AboutComponent } from './about.component';

const routes:Routes = [
  {path:'',component:AboutComponent}
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class AboutRoutingModule { }
