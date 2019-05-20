import { Inject, Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Doctor } from "../models";

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(@Inject("API_URL") private appUrl: string,
              private http: HttpClient) {
  }

  getAll(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(`${this.appUrl}/doctors`);
  }
}
