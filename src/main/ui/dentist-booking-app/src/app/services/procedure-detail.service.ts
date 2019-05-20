import { Inject, Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { BookingDetailResource } from "../models";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProcedureDetailService {

  constructor(@Inject("API_URL") private appUrl: string,
              private http: HttpClient) {
  }

  isAvailableForBooking(bookingDetailResource: BookingDetailResource): Observable<any> {
    return this.http.post<any>(`${this.appUrl}/booking-details/is-available`, bookingDetailResource);
  }
}
