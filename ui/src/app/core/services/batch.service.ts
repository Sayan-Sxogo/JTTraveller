import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Batch } from '../models/interfaces/tour';
import { API } from '../constants/enviroment';
@Injectable({
  providedIn: 'root',
})
export class BatchService {
  baseUrl = 'http://localhost:3000/batches';

  constructor(private http: HttpClient) {}

  getBatches(): Observable<Batch[]> {
    return this.http.get<Batch[]>(this.baseUrl);
  }

  getBatchesAdmin(): Observable<Batch[]> {
    var token = sessionStorage.getItem('_token');
    let head_obj = new HttpHeaders().set('Authorization',"Bearer "+token);
    return this.http.get<Batch[]>(API.baseUrl + API.batches, {headers:head_obj});
  }

  postBatch(value: Batch) {
    return this.http.post(this.baseUrl, JSON.stringify(value), {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
    });
  }
  postBatchesIntegration(data:any,id:any){
    console.log(data,id);
    var token = sessionStorage.getItem('_token')
    let head_obj = new HttpHeaders().set('Authorization',"Bearer "+token)
    return this.http.post(API.baseUrl+API.batches+"/"+API.tourApi+"/"+id,data,{headers:head_obj})
  }
  
}
