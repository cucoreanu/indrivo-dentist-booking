package indrivo.dentistbooking.api

import indrivo.dentistbooking.api.resource.BookingDetailResource
import indrivo.dentistbooking.jpa.service.BookingDetailService
import indrivo.dentistbooking.model.BookingDetail
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("api/booking-details")
@RestController
class BookingDetailController(private val service: BookingDetailService) {

    @PostMapping("/is-available")
    fun isBookingAvailable(@RequestBody bookingDetailResource: BookingDetailResource): ResponseEntity<Any> {
        val bookingDetail = service.getBookingDetail(bookingDetailResource)

        return when (bookingDetail) {
            null -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build()
            else -> canBeBooked(bookingDetail)
        }
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<BookingDetail>> {
        val result = service.getAll()
        return ResponseEntity.ok(result)
    }

    private fun canBeBooked(bookingDetail: BookingDetail): ResponseEntity<Any> {
        return try {
            when {
                service.canBeBooked(bookingDetail) -> ResponseEntity.accepted().build()
                else -> ResponseEntity.status(HttpStatus.CONFLICT).build()
            }
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

}
