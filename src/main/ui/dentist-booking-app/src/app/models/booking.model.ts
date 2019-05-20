import { BookingUser } from "./booking-user.model";

export class Booking {
  id: number;
  version: number;
  comment: string;
  bookingUser: BookingUser;
}
