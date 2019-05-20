package indrivo.dentistbooking.api.resource

import indrivo.dentistbooking.api.validation.ValidationRegExpPatterns
import org.springframework.format.annotation.NumberFormat
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

class BookingResource {
    @NumberFormat
    @NotNull
    var procedureId: Long? = null

    @NumberFormat
    @NotNull
    var doctorId: Long? = null

    @NumberFormat
    @Min(value = 0)
    @NotNull
    var procedureStartTime: Long? = null

    @NotNull
    @Pattern(regexp = ValidationRegExpPatterns.PATIENT_NAME, message = "Invalid name format.")
    var patientFullName: String? = null

    @NotNull
    @Pattern(regexp = ValidationRegExpPatterns.PHONE_NUMBER, message = "Invalid phone number format.")
    var patientPhone: String? = null

    @NotNull
    @Pattern(regexp = ValidationRegExpPatterns.EMAIL, message = "Invalid email.")
    var patientEmail: String? = null
    var comment: String? = null
}
