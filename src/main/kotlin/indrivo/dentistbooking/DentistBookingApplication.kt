package indrivo.dentistbooking

import indrivo.dentistbooking.jpa.service.DoctorService
import indrivo.dentistbooking.jpa.service.ProcedureService
import indrivo.dentistbooking.model.Doctor
import indrivo.dentistbooking.model.Procedure
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DentistBookingApplication(private val doctorService: DoctorService,
                                private val procedureService: ProcedureService) : CommandLineRunner {
    override fun run(vararg args: String?) {
        createTestDoctorRecords()
        createTestProcedureRecords()
    }

    private fun createTestProcedureRecords() {
        var procedures = procedureService.getAll()
        if (procedures.isEmpty()) {
            procedures = listOf(
                    Procedure(name = "Procedure A", duration = 60),
                    Procedure(name = "Procedure B", duration = 20),
                    Procedure(name = "Procedure C", duration = 10),
                    Procedure(name = "Procedure D", duration = 30),
                    Procedure(name = "Procedure E", duration = 90)
            )
            procedures.forEach { procedure -> procedureService.save(procedure) }
        }
    }

    private fun createTestDoctorRecords() {
        var doctors = doctorService.getAll()
        if (doctors.isEmpty()) {
            doctors = listOf(
                    Doctor(name = "Robert"),
                    Doctor(name = "Linda"),
                    Doctor(name = "Alex"),
                    Doctor(name = "Mary")
            )
            doctors.forEach { doctor -> doctorService.save(doctor) }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<DentistBookingApplication>(*args)
}
