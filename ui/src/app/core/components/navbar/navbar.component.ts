import { Component, effect } from '@angular/core';
import { Router } from '@angular/router';
import { initFlowbite } from 'flowbite';
import { AuthService } from '../../services/auth.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  admin!: boolean;
  loginBtn: boolean = true;
  constructor(private authService: AuthService, private route: Router) {
  }

  ngOnInit(): void {
    initFlowbite();
  }
  get isLoggedInAsAdmin() {
    return sessionStorage.getItem('_isLoggedIn') == 'true' && sessionStorage.getItem('role') == 'ADMIN' ? true : false;
  }
  get isLoggedIn() {
    return sessionStorage.getItem('_isLoggedIn') == 'true' ? true : false;
  }
  navigateTo() {
    this.route.navigateByUrl('/profile');
  }
}
