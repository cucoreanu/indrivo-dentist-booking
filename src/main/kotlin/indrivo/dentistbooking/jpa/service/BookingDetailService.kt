package indrivo.dentistbooking.jpa.service

import indrivo.dentistbooking.api.resource.BookingDetailResource
import indrivo.dentistbooking.model.BookingDetail

interface BookingDetailService {
    fun save(bookingDetail: BookingDetail): BookingDetail?
    fun getOne(id: Long): BookingDetail?
    fun canBeBooked(bookingDetail: BookingDetail): Boolean
    fun getBookingDetail(resource: BookingDetailResource): BookingDetail?
    fun getAll(): List<BookingDetail>
}
