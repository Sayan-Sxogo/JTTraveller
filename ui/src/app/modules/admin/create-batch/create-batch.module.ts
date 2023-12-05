import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms'

import { CreateBatchComponent } from './create-batch.component';


@NgModule({
  declarations: [
    CreateBatchComponent
  ],
  exports:[CreateBatchComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ]
})
export class CreateBatchModule { }
