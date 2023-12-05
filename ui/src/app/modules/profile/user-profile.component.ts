import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from 'src/app/core/services/auth.service';
import { BookingService } from 'src/app/core/services/booking.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent {
  email = sessionStorage.getItem('userName')
  name = this.email?.split('@')[0]
  constructor(private router: Router,private authService:AuthService,private bookingService:BookingService) {}

  logout() {
    sessionStorage.clear()  
    this.bookingService.updateNavigatedFromTourList(false)
    this.router.navigate([''])
    return;
  }
}
