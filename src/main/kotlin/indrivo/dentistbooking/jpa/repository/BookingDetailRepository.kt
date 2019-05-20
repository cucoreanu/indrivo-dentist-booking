package indrivo.dentistbooking.jpa.repository

import indrivo.dentistbooking.model.BookingDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BookingDetailRepository : JpaRepository<BookingDetail, Long> {
    fun existsBookingDetailByProcedureStartDateBetweenAndDoctor_Id(startDate: Date, endDate: Date, doctorId: Long): Boolean
}
