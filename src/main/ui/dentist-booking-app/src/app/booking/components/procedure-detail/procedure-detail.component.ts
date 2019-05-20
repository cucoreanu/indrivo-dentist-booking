import { Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { BookingDetailResource, BookingResource, Doctor, Procedure } from "../../../models";
import { ProcedureDetailService } from "../../../services/procedure-detail.service";
import { HttpErrorResponse } from "@angular/common/http";

@Component({
  selector: 'app-procedure-detail',
  templateUrl: './procedure-detail.component.html',
  styleUrls: ['./procedure-detail.component.scss']
})
export class ProcedureDetailComponent implements OnInit {

  @ViewChild('form') form;
  @Input() procedures: Procedure[];
  @Input() doctors: Doctor[];
  @Output() submit = new EventEmitter<any>();
  bookingResource = new BookingResource();
  bookingDate: Date;
  procedureAvailable: boolean;
  minDate: Date;

  constructor(private procedureDetailService: ProcedureDetailService) {
  }

  ngOnInit() {
    this.minDate = new Date(new Date().getTime() + 86400000);
  }

  checkAvailability() {
    if (this.bookingResourceIsValid()) {
      const bookingDetailResource = new BookingDetailResource();
      Object.assign(bookingDetailResource, this.bookingResource);
      bookingDetailResource.procedureStartTime = this.bookingDate.getTime();

      this.procedureDetailService
        .isAvailableForBooking(bookingDetailResource)
        .subscribe(
          () => this.procedureAvailable = true,
          (error: HttpErrorResponse) => {
            if (error.status === 409) {
              this.procedureAvailable = false;
            } else {
              this.procedureAvailable = null;
            }
          });
    }
  }

  private bookingResourceIsValid(): boolean {
    return this.bookingResource.doctorId
      && this.bookingResource.procedureId
      && this.bookingDate
      && !isNaN(this.bookingDate.getTime())
  }

  /**
   * Sends a populated `BookingResource` object to the parent
   * */
  emitSubmit() {
    this.bookingResource.procedureStartTime = this.bookingDate.getTime();
    this.submit.emit(this.bookingResource);
    this.form.reset();
  }
}
