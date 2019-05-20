package indrivo.dentistbooking.api

import indrivo.dentistbooking.jpa.service.DoctorService
import indrivo.dentistbooking.model.Doctor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/doctors")
class DoctorController(private val doctorService: DoctorService) {

    @GetMapping
    fun getAll(): ResponseEntity<List<Doctor>> {
        val allDoctors = doctorService.getAll()
        return if (allDoctors.isEmpty()) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.ok(allDoctors)
        }
    }
}
