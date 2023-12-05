import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { NavbarComponent } from './core/components/navbar/navbar.component';
import { FooterComponent } from './core/components/footer/footer.component';
import { HomeModule } from './modules/home/home.module';
import { HomeComponent } from './modules/home/home.component';
import { SharedModule } from './shared/shared.module';
import { ReactiveFormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
@NgModule({
  declarations: [AppComponent, NavbarComponent, FooterComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeModule,
    HttpClientModule,
    BrowserAnimationsModule,
    SharedModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
