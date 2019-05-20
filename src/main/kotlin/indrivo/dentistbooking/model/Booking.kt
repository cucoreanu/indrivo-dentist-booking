package indrivo.dentistbooking.model

import javax.persistence.*

@Entity
data class Booking(
        @Id
        @GeneratedValue
        var id: Long? = null,
        @Version
        var version: Long? = null,
        var comment: String? = null,

        @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name = "booking_user_id")
        var bookingUser: BookingUser? = null
)
