package indrivo.dentistbooking.jpa.service.impl

import indrivo.dentistbooking.jpa.repository.ProcedureRepository
import indrivo.dentistbooking.jpa.service.ProcedureService
import indrivo.dentistbooking.model.Procedure
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProcedureServiceImpl(private val repository: ProcedureRepository) : ProcedureService {
    companion object {
        private val logger = LogManager.getLogger(this::class)
    }

    override fun getOne(id: Long): Procedure? {
        return try {
            repository.getOne(id)
        } catch (e: Exception) {
            logger.error(e.message)
            null
        }
    }

    override fun getAll(): List<Procedure> {
        return try {
            repository.findAll()
        } catch (e: Exception) {
            logger.error(e.message)
            Collections.emptyList<Procedure>()
        }
    }

    override fun save(procedure: Procedure): Procedure {
        return repository.save(procedure)
    }
}
