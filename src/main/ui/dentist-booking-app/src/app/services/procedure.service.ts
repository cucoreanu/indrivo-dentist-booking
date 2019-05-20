import { Inject, Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Procedure } from "../models";

@Injectable({
  providedIn: 'root'
})
export class ProcedureService {
  constructor(@Inject("API_URL") private appUrl: string,
              private http: HttpClient) {
  }

  getAll(): Observable<Procedure[]> {
    return this.http.get<Procedure[]>(`${this.appUrl}/procedures`);
  }

}
