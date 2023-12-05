import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API } from '../constants/enviroment';

@Injectable({
  providedIn: 'root'
})
export class TourDetailsService {
  url = "http://localhost:8080/batchesDetails"
  constructor(private http:HttpClient) { }

  getTourDetails(){
    return this.http.get(this.url)
  }
  getAllTourBatches(id:any){
    // /tours/{tourId}/batches
    return this.http.get(API.baseUrl+API.tourApi+"/"+id+"/"+API.batches)
  }
}
