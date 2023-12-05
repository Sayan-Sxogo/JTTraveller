import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BatchService } from 'src/app/core/services/batch.service';
import { TourService } from 'src/app/core/services/tour.service';

@Component({
  selector: 'app-view-batches',
  templateUrl: './view-batches.component.html',
  styleUrls: ['./view-batches.component.css'],
})
export class ViewBatchesComponent {
  id: any;
  toursById: any;
  style = {
    fill: '',
    textColor: '',
    bgColor: '',
  };
  constructor(
    private activatedRoute: ActivatedRoute,
    private tourService: TourService,
    private batchesService: BatchService,
    private router:Router
  ) {} 
  batches: any;
  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((params) => {
      this.id = params.get('id');
      // this.tourService.getTourById(this.id).subscribe((res) => {
      //   this.toursById = res;
      //   console.log(this.toursById);
      // });
      // this.batchesService.getBatches().subscribe((res) => {
      //   console.log(res);
      //   this.batches = res;
      // });
    });
    if(sessionStorage.getItem('role')=='ADMIN'){
      this.tourService.getBatchesForAdmin(this.id).subscribe((res)=>{
        this.batches = res
        console.log("res",res);
      })
    }
  }

  toggleForm: boolean = true;
  showForm() {
    // console.log(this.toggleForm)
    this.toggleForm = !this.toggleForm
  }

  navigateTo(){
    this.router.navigate(['/admin/create-batch'])
  }
  // batches: any = [
  //   {
  //     startDate: '2023-11-01',
  //     capacity: 30,
  //     tourGuide: {
  //       name: {
  //         title: 'Mr.',
  //         fName: 'Santosh',
  //         lName: 'Sharma',
  //       },
  //       mobile: { number: '9788612345' },
  //       email: { mailId: 'santosh.sharma@abc.com' },
  //     },
  //     cost: 55000.0,
  //   },
  //   {
  //     startDate: '2023-12-03',
  //     capacity: 20,
  //     tourGuide: {
  //       name: {
  //         title: 'Mrs.',
  //         fName: 'Sanya',
  //         lName: 'Joshi',
  //       },
  //       mobile: { number: '9898765112' },
  //       email: { mailId: 'sanya.joshi@xyz.com' },
  //     },
  //     cost: 40000.0,
  //   },
  //   {
  //     startDate: '2023-04-14',
  //     capacity: 25,
  //     tourGuide: {
  //       name: {
  //         title: 'Mr.',
  //         fName: 'Govind',
  //         lName: 'Kumar',
  //       },
  //       mobile: { number: '8602463528' },
  //       email: { mailId: 'govind.kumar@qrs.com' },
  //     },
  //     cost: 35000.0,
  //   },
  // ];
}
