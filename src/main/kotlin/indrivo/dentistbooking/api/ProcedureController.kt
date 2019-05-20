package indrivo.dentistbooking.api

import indrivo.dentistbooking.jpa.service.ProcedureService
import indrivo.dentistbooking.model.Procedure
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/procedures")
class ProcedureController(private val procedureService: ProcedureService) {
    @GetMapping
    fun getAll(): ResponseEntity<List<Procedure>> {
        val allProcedures = procedureService.getAll()
        return if (allProcedures.isEmpty()) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.ok(allProcedures)
        }
    }
}
