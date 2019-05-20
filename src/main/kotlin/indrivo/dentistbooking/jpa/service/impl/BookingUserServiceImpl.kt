package indrivo.dentistbooking.jpa.service.impl

import indrivo.dentistbooking.jpa.repository.BookingUserRepository
import indrivo.dentistbooking.jpa.service.BookingUserService
import indrivo.dentistbooking.model.BookingUser
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service

@Service
class BookingUserServiceImpl(private val repository: BookingUserRepository) : BookingUserService {
    companion object {
        private val logger = LogManager.getLogger(this::class)
    }

    override fun getOne(id: Long): BookingUser? {
        return try {
            repository.getOne(id)
        } catch (e: Exception) {
            logger.error(e.message)
            null
        }
    }

    override fun save(bookingUser: BookingUser): BookingUser? {
        return try {
            repository.save(bookingUser)
        } catch (e: Exception) {
            logger.error(e.message)
            null
        }
    }
}
