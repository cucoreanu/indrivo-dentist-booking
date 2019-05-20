package indrivo.dentistbooking.model.filter

data class BookingDetailFilter(
        var procedureId: String?,
        var doctorId: String?,
        var procedureDateFrom: String?,
        var procedureDateTo: String?,
        var patientName: String?,
        var patientPhone: String?,
        var patientEmail: String?
)
