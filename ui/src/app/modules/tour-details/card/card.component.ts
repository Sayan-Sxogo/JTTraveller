import { Component, inject, Input, signal, Signal } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/app/core/services/auth.service';
import { BookingService } from 'src/app/core/services/booking.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
})
export class CardComponent {
  @Input() batchId?: any;
  @Input() startDate?: any;
  @Input() endDate?: any;
  @Input() capacity?: any;
  @Input() availableSeats?: any;
  @Input() perParticipantCost?: any;
  @Input() firstName?: any;
  @Input() lastName?: any;

  bookingService = inject(BookingService);
  authService = inject(AuthService);
  toastr = inject(ToastrService)

  adminBookingNotAllowed = false;
  constructor(private router: Router) {}
  fill: string = '';
  modeItem: string = '';
  style = {
    fill: '',
    textColor: '',
    bgColor: '',
  };
  modeGifs = {
    WALK: 'assets/gifs/walk.gif',
    MOTORBIKE: 'assets/gifs/bike1.gif',
    BICYCLE: 'assets/gifs/cycle.gif',
  };
  ngOnInit() {}

  onNaviagte() {
    if (sessionStorage.getItem('role') == 'ADMIN') {
      this.adminBookingNotAllowed = true;
      this.toastr.warning('Login as a Customer to proceed furthur...')
      return;
    }
    if (
      sessionStorage.getItem('_isLoggedIn') == 'true' &&
      sessionStorage.getItem('role') == 'CUSTOMER'
    ) {
      this.bookingService.updateBatchData(
        this.batchId,
        this.startDate,
        this.availableSeats,
        this.perParticipantCost
      );
      this.router.navigateByUrl('/booking');
    } else {
      this.bookingService.updateNavigatedFromTourList(true); // it will reflect of login and come back
      this.router.navigateByUrl('/login');
    }
  }
}