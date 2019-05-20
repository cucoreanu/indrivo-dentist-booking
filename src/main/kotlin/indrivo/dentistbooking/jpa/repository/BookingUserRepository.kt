package indrivo.dentistbooking.jpa.repository

import indrivo.dentistbooking.model.BookingUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookingUserRepository : JpaRepository<BookingUser, Long>
