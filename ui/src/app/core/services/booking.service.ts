import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, inject, signal } from '@angular/core';
import { API } from '../constants/enviroment';
import { Observable, of } from 'rxjs';
 
@Injectable({
  providedIn: 'root',
})
export class BookingService {
  batchData = signal<{ batchId:number | null, startDate:any,seats: number | null; costs: number | null }>({
    batchId:null,
    startDate:null,
    seats: null,
    costs: null,
  });
  participantList = signal<Array<any>>([])
  navigatedFromTourList = signal<Boolean>(false)  // navigation to login page again come back after login
  http = inject(HttpClient)
  constructor() {}
  updateBatchData(batchId:number, startDate:any,seats: number, costs: number) {
    this.batchData.set({ batchId , startDate ,seats, costs });
  }
  updateParticipantData(val:any){
    this.participantList.set(val)
  }
  updateNavigatedFromTourList(val:boolean){
    this.navigatedFromTourList.set(val);
  }
  bookingDataPost(data:any){
    var token = sessionStorage.getItem('_token')
    let head_obj = new HttpHeaders().set('Authorization',"Bearer "+token)
    var role = sessionStorage.getItem('role')
    if(role ==  'CUSTOMER'){
      console.log("booking role ",role);
      return this.http.post(API.baseUrl+API.batches+"/"+API.book,data, {headers:head_obj})
    }
    return of({message:"not customer"});
  }
  getAllBookings():Observable<any> {
    var token = sessionStorage.getItem('_token')
    let head_obj = new HttpHeaders().set('Authorization',"Bearer "+token)
    return this.http.get(API.baseUrl+'booking', {headers:head_obj})
  }
}