package indrivo.dentistbooking.jpa.service

import indrivo.dentistbooking.api.resource.BookingResource
import indrivo.dentistbooking.model.Booking

interface BookingService {
    fun save(booking: Booking): Booking?
    fun save(resource: BookingResource): Booking?
}
