import { Component, Input, OnInit } from '@angular/core';
import { BookingDetail } from "../../models";

interface BookingDetailInterface {
  doctor: string;
  procedure: string;
  procedureStartDate: Date;
  patientName: string;
  email: string;
  phone: string;
  comment: string;
}

@Component({
  selector: 'app-data-table',
  templateUrl: './data-table.component.html',
  styleUrls: ['./data-table.component.scss']
})
export class DataTableComponent implements OnInit {

  @Input() bookings: BookingDetail[];

  constructor() { }

  ngOnInit() {
  }

}
