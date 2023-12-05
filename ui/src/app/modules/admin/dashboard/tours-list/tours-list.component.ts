import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Difficulty } from 'src/app/core/models/enums/difficulty';
import { Status } from 'src/app/core/models/enums/status';
import { Tour } from 'src/app/core/models/interfaces/tour';

@Component({
  selector: 'app-tours-list',
  templateUrl: './tours-list.component.html',
  styleUrls: ['./tours-list.component.css'],
})

// class Tour {}
export class ToursListComponent implements OnInit {
  @Input() tours: Tour[] = [];
  constructor(private router: Router,private activatedRoute:ActivatedRoute) {}
  ngOnInit() {
  }
  navigate(id:any) {
    this.router.navigate(['/admin/view-batches',id]);
  }
}
