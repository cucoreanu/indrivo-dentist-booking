import { Inject, Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { BookingResource } from "../models";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(@Inject("API_URL") private appUrl: string,
              private http: HttpClient) {
  }

  save(bookingResource: BookingResource): Observable<any> {
    return this.http.post<any>(`${this.appUrl}/bookings`, bookingResource);
  }

}
