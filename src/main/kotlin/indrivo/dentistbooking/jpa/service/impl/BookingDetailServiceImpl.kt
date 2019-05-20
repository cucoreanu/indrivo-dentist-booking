package indrivo.dentistbooking.jpa.service.impl

import indrivo.dentistbooking.api.resource.BookingDetailResource
import indrivo.dentistbooking.jpa.repository.BookingDetailRepository
import indrivo.dentistbooking.jpa.service.BookingDetailService
import indrivo.dentistbooking.jpa.service.DoctorService
import indrivo.dentistbooking.jpa.service.ProcedureService
import indrivo.dentistbooking.model.BookingDetail
import indrivo.dentistbooking.util.DateUtil
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookingDetailServiceImpl(private val repository: BookingDetailRepository,
                               private val procedureService: ProcedureService,
                               private val doctorService: DoctorService) : BookingDetailService {

    companion object {
        private val logger = LogManager.getLogger(this::class)
    }

    override fun save(bookingDetail: BookingDetail): BookingDetail? {
        return try {
            repository.save(bookingDetail)
        } catch (e: Exception) {
            logger.error(e.message)
            null
        }
    }

    override fun getOne(id: Long): BookingDetail? {
        return try {
            repository.getOne(id)
        } catch (e: Exception) {
            logger.error(e.message)
            null
        }
    }

    @Throws(Exception::class)
    override fun canBeBooked(bookingDetail: BookingDetail): Boolean {
        return try {
            var startDate = bookingDetail.procedureStartDate
            if (startDate.time < Date().time) {
                return false
            }
            val procedureDuration = bookingDetail.procedure.duration * 60000
            val endDate = DateUtil.addMillisecondsToDate(startDate, procedureDuration)
            startDate = DateUtil.addMillisecondsToDate(startDate, -procedureDuration)
            !existsBetween(startDate, endDate, bookingDetail.doctor.id!!)
        } catch (e: Exception) {
            logger.error(e.message)
            throw Exception("Error while the checking availability.")
        }
    }

    override fun getBookingDetail(resource: BookingDetailResource): BookingDetail? {
        val procedure = procedureService.getOne(resource.procedureId)
        val doctor = doctorService.getOne(resource.doctorId)
        return if (doctor == null || procedure == null) {
            null
        } else {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = resource.procedureStartTime
            val procedureStartDate = calendar.time
            BookingDetail(procedure = procedure, doctor = doctor, procedureStartDate = procedureStartDate)
        }
    }

    override fun getAll(): List<BookingDetail> {
        return try {
            repository.findAll()
        } catch (e: Exception) {
            logger.error(e.message)
            Collections.emptyList()
        }
    }

    private fun existsBetween(start: Date, end: Date, doctorId: Long): Boolean {
        return try {
            repository.existsBookingDetailByProcedureStartDateBetweenAndDoctor_Id(start, end, doctorId)
        } catch (e: Exception) {
            logger.error(e.message)
            false
        }
    }
}
