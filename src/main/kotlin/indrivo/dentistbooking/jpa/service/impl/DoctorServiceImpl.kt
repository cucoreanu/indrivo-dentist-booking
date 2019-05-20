package indrivo.dentistbooking.jpa.service.impl

import indrivo.dentistbooking.jpa.repository.DoctorRepository
import indrivo.dentistbooking.jpa.service.DoctorService
import indrivo.dentistbooking.model.Doctor
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service
import java.util.*

@Service
class DoctorServiceImpl(private val repository: DoctorRepository) : DoctorService {
    companion object {
        private val logger = LogManager.getLogger(this::class)
    }

    override fun getOne(id: Long): Doctor? {
        return try {
            repository.getOne(id)
        } catch (e: Exception) {
            logger.error(e.message)
            null
        }
    }

    override fun getAll(): List<Doctor> {
        return try {
            repository.findAll()
        } catch (e: Exception) {
            logger.error(e.message)
            Collections.emptyList<Doctor>()
        }
    }

    override fun save(doctor: Doctor): Doctor {
        return repository.save(doctor)
    }
}
