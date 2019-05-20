import { Inject, Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { BookingDetail } from "../models";

@Injectable({
  providedIn: 'root'
})
export class BookingDetailService {

  constructor(@Inject("API_URL") private appUrl: string,
              private http: HttpClient) {
  }

  getAll(): Observable<BookingDetail[]> {
    return this.http.get<BookingDetail[]>(`${this.appUrl}/booking-details`)
  }

}
