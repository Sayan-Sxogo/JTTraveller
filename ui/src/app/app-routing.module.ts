import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { authGuard } from './core/guard/auth.guard';
import { AboutComponent } from './modules/about/about.component';
import { BookingComponent } from './modules/admin/dashboard/booking/booking.component';
import { HomeComponent } from './modules/home/home.component';
import { UserProfileComponent } from './modules/profile/user-profile.component';
import { ErrorpageComponent } from './shared/components/errorpage/errorpage.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    path: 'admin',
    loadChildren: () =>
      import('./modules/admin/admin.module').then((m) => m.AdminModule),
    canActivate: [authGuard],
  },
  {
    path: '',
    loadChildren: () =>
      import('./modules/auth/auth.module').then((m) => m.AuthModule),
  },
  { path: 'profile', component: UserProfileComponent },
  { path: 'about', component: AboutComponent },
  
  {
    path: 'tour',
    loadChildren: () =>
      import('./modules/tour-details/tour-details.module').then(
        (m) => m.TourDetailsModule
      ),
  },
  {
    path: 'booking',
    loadChildren: () =>
      import('./modules/booking/booking.module').then((m) => m.BookingModule),
  },
  {
    path: 'testbook',
    component:BookingComponent
  },
  {
    path:'alltours',loadChildren :()=> import('./modules/alltours/alltours.module').then((m)=>m.AlltoursModule)
  },
  { path: '**', component: ErrorpageComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
