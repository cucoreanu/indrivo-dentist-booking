package indrivo.dentistbooking.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
data class BookingDetail(
        @Id
        var id: Long? = null,

        @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name = "procedure_id")
        var procedure: Procedure,

        @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name = "doctor_id")
        var doctor: Doctor,
        var procedureStartDate: Date,

        @OneToOne(fetch = FetchType.LAZY)
        @MapsId
        var booking: Booking? = null
)
