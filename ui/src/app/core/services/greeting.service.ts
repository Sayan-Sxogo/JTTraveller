import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_KEY, quoteAPI } from '../constants/enviroment';

@Injectable({
  providedIn: 'root',
})
export class GreetingService {
  constructor(private http: HttpClient) {}

  getRandomQuote() {
    return this.http.get(quoteAPI.baseUrl + quoteAPI.query, {
      headers: { 'X-Api-Key': API_KEY },
    });
  }
}
