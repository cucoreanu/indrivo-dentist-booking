package indrivo.dentistbooking.api.resource

data class BookingDetailResource(
        var procedureId: Long,
        var doctorId: Long,
        var procedureStartTime: Long
)
