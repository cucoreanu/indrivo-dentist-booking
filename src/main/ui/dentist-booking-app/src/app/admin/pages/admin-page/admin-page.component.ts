import { Component, OnInit } from '@angular/core';
import { BookingDetail, Doctor, Procedure } from "../../../models";
import { ProcedureService } from "../../../services/procedure.service";
import { DoctorService } from "../../../services/doctor.service";
import { MatSnackBar } from "@angular/material";
import { BookingService } from "../../../services/booking.service";
import { BookingDetailService } from "../../../services/booking-detail.service";

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.scss']
})
export class AdminPageComponent implements OnInit {

  /**
   * Specifies if the current component is loading
   * */
  isLoading: boolean;
  procedures: Procedure[];
  doctors: Doctor[];
  bookingDetails: BookingDetail[];

  constructor(private procedureService: ProcedureService,
              private doctorService: DoctorService,
              private snackBar: MatSnackBar,
              private bookingService: BookingService,
              private bookingDetailService: BookingDetailService) { }

  ngOnInit() {
    this.isLoading = true;
    this.fetch().then(() => {
      this.isLoading = false;
      console.log(this.bookingDetails)
    })
  }

  /**
   * Loads initial data from server: the procedures, the doctors and the bookings
   * */
  private async fetch() {
    await this.procedureService.getAll()
      .toPromise()
      .then(result => this.procedures = result)
      .catch(() => console.log('Could not get the procedures'));

    await this.doctorService.getAll()
      .toPromise()
      .then(result => this.doctors = result)
      .catch(() => console.log('Could not get the doctors'));

    await this.bookingDetailService.getAll()
      .toPromise()
      .then(result => this.bookingDetails = result)
      .catch(() => console.log('Could not get the booking details'));
  }

}
