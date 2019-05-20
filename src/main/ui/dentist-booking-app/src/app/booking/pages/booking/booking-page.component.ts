import { Component, OnInit } from '@angular/core';
import { BookingResource, Doctor, Procedure } from "../../../models";
import { ProcedureService } from "../../../services/procedure.service";
import { DoctorService } from "../../../services/doctor.service";
import { MatSnackBar } from "@angular/material";
import { BookingService } from "../../../services/booking.service";

@Component({
  selector: 'app-booking-page',
  templateUrl: './booking-page.component.html',
  styles: []
})
export class BookingPage implements OnInit {

  /**
   * Specifies if the current component is loading
   * */
  isLoading: boolean;
  procedures: Procedure[];
  doctors: Doctor[];

  constructor(private procedureService: ProcedureService,
              private doctorService: DoctorService,
              private snackBar: MatSnackBar,
              private bookingService: BookingService) { }

  ngOnInit() {
    this.isLoading = true;
    this.fetch().then(() => {
      this.isLoading = false;
    })
  }

  /**
   * Loads initial data from server: the procedure and doctor lists
   * */
  private async fetch() {
    await this.procedureService.getAll()
      .toPromise()
      .then(result => this.procedures = result)
      .catch(() => console.log('exception'));
    await this.doctorService.getAll()
      .toPromise()
      .then(result => this.doctors = result)
      .catch(() => console.log('exception'));
  }

  save($event: BookingResource) {
    console.log($event);
    this.bookingService.save($event).subscribe(
      () => this.snackBar.open("The booking was saved", 'Close', { duration: 3000 }),
      () => this.snackBar.open("The request could not been processed", null, { duration: 3000 })
    );
  }
}
