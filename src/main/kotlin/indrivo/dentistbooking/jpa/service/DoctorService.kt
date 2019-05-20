package indrivo.dentistbooking.jpa.service

import indrivo.dentistbooking.model.Doctor

interface DoctorService {
    fun getOne(id: Long): Doctor?
    fun getAll(): List<Doctor>
    fun save(doctor: Doctor): Doctor
}
