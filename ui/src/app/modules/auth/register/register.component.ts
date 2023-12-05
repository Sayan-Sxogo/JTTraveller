import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/core/services/auth.service';
 
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  passMatchErr:boolean = false;
  showError: boolean = false;
  emailRegex = '^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$';
 
  constructor(private user: AuthService, private router: Router) {}
 
  Registration = new FormGroup({
    userName: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(6),
    ]),
    reEnterPassword: new FormControl('', [Validators.required]),
  });
 
  Register() {
    if (this.Registration.invalid) {
      this.showError = true;
    } else {
      let newUser = { role: 'CUSTOMER', ...this.Registration.value };
      delete newUser.reEnterPassword;
      this.user.registerUser(newUser).subscribe((result: any) => {
        return result;
      });
      this.Registration.reset();
      this.router.navigateByUrl('/login');
    }
  }
 
  matchPassword() {
    if (this.Registration.get('reEnterPassword')?.dirty || this.Registration.get('reEnterPassword')?.touched) {
      if ((this.Registration.value.password === this.Registration.value.reEnterPassword))
        this.passMatchErr = false;
      else this.passMatchErr = true;
    }
  }
 
  get userName() {
    return this.Registration.get('userName');
  }
  get email() {
    return this.Registration.get('email');
  }
  get password() {
    return this.Registration.get('password');
  }
  get mobile() {
    return this.Registration.get('mobile');
  }
}