package indrivo.dentistbooking.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class BookingUser(
        @Id
        @GeneratedValue
        var id: Long? = null,
        var fullName: String,
        var phone: String,
        var email: String
)
