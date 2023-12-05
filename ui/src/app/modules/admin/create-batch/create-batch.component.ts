import { Component, OnInit, inject } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
 
import { BatchService } from 'src/app/core/services/batch.service';
 
@Component({
  selector: 'app-create-batch',
  templateUrl: './create-batch.component.html',
  styleUrls: ['./create-batch.component.css'],
})
export class CreateBatchComponent implements OnInit {
  createBatchForm: FormGroup;
  activatedRoute = inject(ActivatedRoute);
  id: any;
 
  constructor(private batchService: BatchService, private router: Router) {
    this.createBatchForm = new FormGroup({
      startDate: new FormControl([Validators.required]),
      capacity: new FormControl('', [
        Validators.required,
        Validators.min(1),
        Validators.max(999),
      ]),
      perParticipantCost: new FormControl('', [
        Validators.required,
        Validators.min(1),
        Validators.max(999999),
      ]),
      guide: new FormGroup({
        name: new FormGroup({
          first: new FormControl('', [
            Validators.required,
            Validators.minLength(3),
            Validators.maxLength(50),
          ]),
          last: new FormControl('', [
            Validators.required,
            Validators.minLength(2),
            Validators.maxLength(50),
          ]),
        }),
        mobile: new FormGroup({
          number: new FormControl('', [
            Validators.required,
            Validators.pattern('^[0-9]{10}$'),
          ]),
        }),
      }),
    });
 
    this.activatedRoute.paramMap.subscribe((params) => {
      this.id = params.get('id');
      console.log(this.id);
      console.log('id called ');
    });
  }
 
  ngOnInit(): void {}
 
  onSubmit() {
    // console.log('Is Valid: ' + this.createBatchForm.valid);
    // // console.log(this.createBatchForm);
    // console.log(this.createBatchForm.controls);
    // console.log(
    //   this.createBatchForm.get('guide')?.get('name')?.get('first')?.errors
    // );
 
    // if (this.createBatchForm.valid) {
    //   console.log("if called");
    //   this.batchService
    //     .postBatch(this.createBatchForm.value)
    //     .subscribe((data) => {
    //       console.log('New Batch Posted');
    //       console.log(data);
    //     });
    // }
    if (this.createBatchForm.valid) {
      this.batchService
        .postBatchesIntegration(this.createBatchForm.value, this.id)
        .subscribe((data) => {
          console.log('New Batch Posted');
          // console.log(data);
          this.createBatchForm.reset();
          this.router.navigateByUrl('/admin/dashboard');
        });
    }
  }
}
 
/*
        mobile: new FormGroup({
          number: new FormControl('',[
            (control)=>{
              if(control.parent && control.parent.get('number')?.touched){
                return Validators.required(control);
              }
              return null;
            },
            Validators.pattern(/^\d{10}$/)
          ]),
        }),
*/