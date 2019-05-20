package indrivo.dentistbooking.jpa.repository

import indrivo.dentistbooking.model.Booking
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
interface BookingRepository : JpaRepository<Booking, Long>
