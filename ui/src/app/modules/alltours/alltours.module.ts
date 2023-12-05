import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AlltoursComponent } from './alltours.component';
import { Routes,RouterModule } from '@angular/router';
import { CardComponent } from './card/card.component';
import { SharedModule } from 'src/app/shared/shared.module';

const routes: Routes = [
  {path:'',component:AlltoursComponent}
]

@NgModule({
  declarations: [
    AlltoursComponent,
    CardComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(routes)
  ]
})
export class AlltoursModule { }
