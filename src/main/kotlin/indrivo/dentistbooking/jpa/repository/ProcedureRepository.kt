package indrivo.dentistbooking.jpa.repository

import indrivo.dentistbooking.model.Procedure
import org.springframework.data.jpa.repository.JpaRepository

interface ProcedureRepository : JpaRepository<Procedure, Long>
