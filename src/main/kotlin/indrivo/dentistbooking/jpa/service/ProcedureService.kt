package indrivo.dentistbooking.jpa.service

import indrivo.dentistbooking.model.Procedure

interface ProcedureService {
    fun getOne(id: Long): Procedure?
    fun getAll(): List<Procedure>
    fun save(procedure: Procedure): Procedure
}
