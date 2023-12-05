import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API } from '../constants/enviroment';

@Injectable({
  providedIn: 'root'
})
export class StatsService {

  constructor(private http:HttpClient) { }
  tourSize!:number
  getAllTours(){
    console.log("stat services")
    this.http.get(API.baseUrl+API.tourApi).subscribe((res)=>{
      let result:any = res;
      this.tourSize = result.length
      console.log("tour size ",this.tourSize)
    })
    return this.tourSize
  }
}
