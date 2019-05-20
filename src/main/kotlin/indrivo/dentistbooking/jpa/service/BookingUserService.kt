package indrivo.dentistbooking.jpa.service

import indrivo.dentistbooking.model.BookingUser

interface BookingUserService {
    fun getOne(id: Long): BookingUser?
    fun save(bookingUser: BookingUser): BookingUser?
}
