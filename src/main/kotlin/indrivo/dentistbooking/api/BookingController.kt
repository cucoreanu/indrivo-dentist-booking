package indrivo.dentistbooking.api

import indrivo.dentistbooking.api.resource.BookingDetailResource
import indrivo.dentistbooking.api.resource.BookingResource
import indrivo.dentistbooking.jpa.service.BookingDetailService
import indrivo.dentistbooking.jpa.service.BookingService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class BookingController(private val service: BookingService,
                        private val bookingDetailService: BookingDetailService) {

    @PostMapping("/bookings")
    fun book(@Validated @RequestBody resource: BookingResource): ResponseEntity<Any> {
        if (!canBeBooked(resource)) {
            return ResponseEntity.badRequest().build()
        }
        val savedResource = service.save(resource)
        return if (savedResource == null) {
            ResponseEntity.badRequest().build()
        } else {
            ResponseEntity.ok().build()
        }
    }

    private fun canBeBooked(resource: BookingResource): Boolean {
        val bookingDetail = bookingDetailService.getBookingDetail(getBookingDetailResource(resource))!!
        return bookingDetailService.canBeBooked(bookingDetail)

    }

    private fun getBookingDetailResource(resource: BookingResource): BookingDetailResource {
        return BookingDetailResource(resource.procedureId!!, resource.doctorId!!, resource.procedureStartTime!!)
    }
}
