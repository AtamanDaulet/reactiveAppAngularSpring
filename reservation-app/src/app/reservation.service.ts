import { Injectable } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http:HttpClientModule){}

  private baseUrl = 'http://localhost:8081'
  private reservationUrl:string = this.baseUrl + '/room/v1/reservation/';
}
