import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ViewBatchesComponent } from './view-batches.component';
import { CreateBatchModule } from '../create-batch/create-batch.module';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [ViewBatchesComponent],
  imports: [CommonModule,CreateBatchModule,SharedModule],
})
export class ViewBatchesModule {}
