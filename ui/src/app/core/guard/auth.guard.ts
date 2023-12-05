import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { inject } from '@angular/core';

export const authGuard: CanActivateFn = (route, state) => {
  let role = sessionStorage.getItem('role')
  let router = inject(Router)
  if(role === 'ADMIN') {
    return true;
  }
  router.navigateByUrl('')
  return false
};
