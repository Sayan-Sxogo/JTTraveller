import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DifficultyComponent } from './components/badge/difficulty/difficulty.component';
import { StatusComponent } from './components/badge/status/status.component';
import { IconComponent } from './components/icon/icon.component';
import { ErrorpageComponent } from './components/errorpage/errorpage.component';

@NgModule({
  declarations: [DifficultyComponent, StatusComponent, IconComponent, ErrorpageComponent],
  exports: [DifficultyComponent, IconComponent],
  imports: [CommonModule],
})
export class SharedModule {}
