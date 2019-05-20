import { Procedure } from "./procedure.model";
import { Doctor } from "./doctor.model";
import { Booking } from "./booking.model";

export class BookingDetail {
  id: number;
  procedure: Procedure;
  doctor: Doctor;
  procedureStartDate: Date;
  booking: Booking
}
