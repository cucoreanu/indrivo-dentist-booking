package indrivo.dentistbooking.jpa.service.impl

import indrivo.dentistbooking.api.resource.BookingResource
import indrivo.dentistbooking.jpa.repository.BookingRepository
import indrivo.dentistbooking.jpa.service.*
import indrivo.dentistbooking.model.Booking
import indrivo.dentistbooking.model.BookingDetail
import indrivo.dentistbooking.model.BookingUser
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookingServiceImpl(private val repository: BookingRepository,
                         private val procedureService: ProcedureService,
                         private val doctorService: DoctorService,
                         private val bookingDetailService: BookingDetailService,
                         private val userService: BookingUserService) : BookingService {
    companion object {
        private val logger = LogManager.getLogger(this::class)
    }

    override fun save(booking: Booking): Booking? {
        return try {
            repository.save(booking)
        } catch (e: Exception) {
            logger.error(e.message)
            null
        }
    }

    override fun save(resource: BookingResource): Booking? {
        return try {
            if (!isResourceValid(resource)) {
                return null
            }
            // Validating user data
            val procedure = procedureService.getOne(resource.procedureId!!)
            val doctor = doctorService.getOne(resource.doctorId!!)
            val procedureCalendar = Calendar.getInstance()
            procedureCalendar.timeInMillis = resource.procedureStartTime!!
            val procedureStartTime: Date = procedureCalendar.time
            val booking = Booking()

            // Creating new User
            val bookingUser = userService.save(
                    BookingUser(fullName = resource.patientFullName!!,
                            phone = resource.patientPhone!!,
                            email = resource.patientEmail!!)
            )
            booking.bookingUser = bookingUser

            // Building booking object
            if (procedure == null || doctor == null) {
                return null
            }
            booking.comment = resource.comment
            val newBooking = repository.save(booking)
            val bookingDetail = BookingDetail(
                    procedure = procedure,
                    doctor = doctor,
                    procedureStartDate = procedureStartTime,
                    booking = newBooking)
            bookingDetailService.save(bookingDetail)?.booking
        } catch (e: Exception) {
            logger.error(e.message)
            null
        }
    }

    fun isResourceValid(resource: BookingResource): Boolean {
        return resource.doctorId != null
                && resource.procedureId != null
                && resource.patientEmail != null
                && resource.patientFullName != null
                && resource.patientPhone != null
                && resource.procedureStartTime != null
    }
}
