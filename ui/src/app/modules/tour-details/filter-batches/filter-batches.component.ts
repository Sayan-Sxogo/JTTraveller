import { Component, ElementRef, Renderer2, ViewChild } from '@angular/core';

@Component({
  selector: 'app-filter-batches',
  templateUrl: './filter-batches.component.html',
  styleUrls: ['./filter-batches.component.css'],
})
export class FilterBatchesComponent {
  @ViewChild('dateInput') dateInput!: ElementRef;
  selectedFromDate!: string;
  showDatePicker!: string;

  constructor(private renderr: Renderer2) {}

  // ngAfterViewInit() {
  //   if (this.showDatePicker == 'fromDate') {
  //     setTimeout(() => {
  //       this.renderr
  //         .selectRootElement(this.dateInput.nativeElement)
  //         .dispatchEvent(new Event('input'));
  //     });
  //   }
  // }
  openDatePicker(dateType: string) {
    this.showDatePicker = dateType;
    console.log(this.dateInput);
    this.dateInput.nativeElement.addEventListener('change', (ev: any) => {
      console.log(ev);
    });
  }
}
