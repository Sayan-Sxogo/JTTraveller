import { Injectable, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API } from '../../core/constants/enviroment';
import { BehaviorSubject, Observable, of } from 'rxjs';
@Injectable({
  providedIn: 'root',
}) 
export class AuthService {
  private url = API.baseUrl + API.authApi;
  isLoggedIn = new BehaviorSubject<boolean>(false);
  constructor(private http: HttpClient) {
    console.log("auth constrct",this.isLoggedIn);
  }
  registerUser(result: any) {
    console.log(result);
    return this.http.post(this.url+"/register", result);
  }
  loginUser(result:any){
    return this.http.post(this.url+"/login",result,{observe:'response'});
  }
  getUsers() {
    return this.http.get(this.url);
  }
  getUserByCode(value: any) {
    return this.http.get("http://localhost:3000/users?userName="+ value);
  }
  isLogIn() {
    console.log("is login service",this.isLoggedIn);
    return this.isLoggedIn;
  }
  // getRole(): Observable<string | undefined> {
  //   console.log('get role called');
  //   const value =
  //     sessionStorage.getItem('role') != null
  //       ? sessionStorage.getItem('role')?.toString()
  //       : '';
  //   console.log(value);
  //   return of(value);
  // }
  getRole() {
    console.log('get role called');
    return sessionStorage.getItem('role') != null
      ? sessionStorage.getItem('role')?.toString()
      : '';
  }
  isLoggedInUrl() {
    console.log('auth service ' + this.isLoggedIn);
    console.log(this.isLoggedIn);
    if (this.isLoggedIn) return true;
    return false;
  }

  // loginState = signal(false)
  loginStateTest = new BehaviorSubject<Boolean>(false);
  // updateLoginState(value:any){
  //   console.log("login state called update");
  //   this.loginState.set(value);
  //   console.log(this.loginState());
  // }
  updateLoginStateTest(value:any){
    this.loginStateTest.next(value)
  }
  
}
