package indrivo.dentistbooking.jpa.repository

import indrivo.dentistbooking.model.Doctor
import org.springframework.data.jpa.repository.JpaRepository

interface DoctorRepository : JpaRepository<Doctor, Long>
