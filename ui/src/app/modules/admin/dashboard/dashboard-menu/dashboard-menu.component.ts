import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/core/services/auth.service';

@Component({
  selector: 'app-dashboard-menu',
  templateUrl: './dashboard-menu.component.html',
  styleUrls: ['./dashboard-menu.component.css'],
})
export class DashboardMenuComponent {
  icons: any = [
    {
      iconUrl: 'assets/gifs/dashboard.gif',
      name: 'Dashboard',
      navigate: '/dashboard',
    },
    {
      iconUrl: 'assets/gifs/addTour.gif',
      name: 'Create Tour',
      navigate: '/admin/add-tour',
    },
    {
      iconUrl: 'assets/gifs/about.gif',
      name: 'About',
      navigate: '/about',
    },
    {
      iconUrl: 'assets/gifs/about.gif',
      name: 'All Booking',
      navigate: '/admin/bookings',
    },
    {
      iconUrl: 'assets/gifs/logout.gif',
      name: 'Log Out',
      navigate: '/logout',
    },
  ];
  constructor(private router: Router,private authService:AuthService) {}

  navigateTo(navigate: string) {
    console.log(navigate);
    if(navigate == '/logout'){
      console.log("logout called");
      // sessionStorage.setItem('username','')
      // sessionStorage.setItem('role','')
      sessionStorage.clear()
      this.authService.isLoggedIn.next(false)
      this.router.navigate([''])
      return;
    }
    this.router.navigate([navigate]);
  }
}
