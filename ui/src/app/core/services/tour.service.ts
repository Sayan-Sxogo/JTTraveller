import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tour } from '../models/interfaces/tour';
import { BehaviorSubject } from 'rxjs';
import { API } from '../../core/constants/enviroment';
 
@Injectable({
  providedIn: 'root',
})
export class TourService {
 
  private url = API.baseUrl + API.tourApi;
  id: any;
 
  baseTour = new BehaviorSubject<Object>({}); //* Used to pass data from add-tour -> add-iti
  testData = new BehaviorSubject<number>(0); //* Used to pass data from add-tour -> add-iti
 
  constructor(private http: HttpClient) {}
 
  getTours(): Observable<Tour[]> {
    return this.http.get<Tour[]>(this.url);
  }

  getPopularTours(){
    return this.http.get(this.url+"/popularTours") //tours/popularTours
  }
 
  dayCardStatus = new BehaviorSubject<boolean>(false);
  defaultCountDay = new BehaviorSubject<number>(0);
 
  //this is for showing durtaion card in itinerary component
  private daysSource = new BehaviorSubject<number>(0);
  days$ = this.daysSource.asObservable();
 
  //when clicking on add button in form status changes 'plus->done'
  private iconStateSource = new BehaviorSubject<string>('plus');
  iconState$ = this.iconStateSource.asObservable();
 
  setDays(days: number) {
    this.daysSource.next(days);
  }
 
  setIconState(state: string) {
    this.iconStateSource.next(state);
  }
 
  addTourData(result: any) {
    var token = sessionStorage.getItem('_token')
    var headers = new HttpHeaders({
      'Content-Type':'application/json',
      'Authorization':`Bearer ${token}`
    })
    let head_obj = new HttpHeaders().set('Authorization',"Bearer "+token)
    return this.http.post(this.url, result,{headers:head_obj});
  }
 
  getBatchesById(id:any){
    // /tours/{tourId}/batches  
    return this.http.get(API.baseUrl+API.tourApi+"/"+id+"/"+API.batches)
  }
 
  getTourById(id:any){
    // /tours/{tourId}/batches  
    return this.http.get(API.baseUrl+API.tourApi+"/"+id+"/"+API.batches)
  }
 
  getBatchesForAdmin(id:any){
    var token = sessionStorage.getItem('_token')
    let head_obj = new HttpHeaders().set('Authorization',"Bearer "+token)
    return this.http.get(API.baseUrl+API.tourApi+"/"+id+"/"+API.batches,{headers:head_obj})
  }
}